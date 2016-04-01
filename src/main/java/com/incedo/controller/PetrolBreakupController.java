package com.incedo.controller;

import java.util.HashMap;
import java.util.Map;

import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderError;
import org.drools.builder.KnowledgeBuilderErrors;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.ResourceFactory;
import org.drools.runtime.StatefulKnowledgeSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.incedo.bean.ItemState;

@Controller
public class PetrolBreakupController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView welcome(@ModelAttribute("command") ItemState itemState, BindingResult result) {
		return new ModelAndView("petrol_breakup_info");
	}

	@RequestMapping(value = "/showInfo", method = RequestMethod.POST)
	public ModelAndView showInfo(@ModelAttribute("command") ItemState itemState, BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			// load up the knowledge base
			KnowledgeBase kbase = readKnowledgeBase();
			StatefulKnowledgeSession ksession = kbase.newStatefulKnowledgeSession();
			ksession.insert(itemState);
			ksession.fireAllRules();

			model.put("itemState", itemState);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("petrol_breakup_info", model);
	}

	
	private static KnowledgeBase readKnowledgeBase() throws Exception {
		KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
		kbuilder.add(ResourceFactory.newClassPathResource("rules/ItemState.drl"), ResourceType.DRL);
		KnowledgeBuilderErrors errors = kbuilder.getErrors();
		if (errors.size() > 0) {
			for (KnowledgeBuilderError error : errors) {
				System.err.println(error);
			}
			throw new IllegalArgumentException("Could not parse knowledge.");
		}
		KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
		kbase.addKnowledgePackages(kbuilder.getKnowledgePackages());
		return kbase;
	}

}