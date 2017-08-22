package org.park.javadesignpattern.builder.example;

public class InstanceManager {
	
	private Director director;
	private TextBuilderInfa textbuilder;
	private HTMLBuilderInfa htmlbuilder;
	public InstanceManager() {
		this.director = new Director();
		this.textbuilder = new TextBuilderInfa();
		this.htmlbuilder = new HTMLBuilderInfa();
	}
	public Director getDirector() {
		return director;
	}
	public TextBuilderInfa getTextbuilder() {
		return textbuilder;
	}
	public HTMLBuilderInfa getHtmlbuilder() {
		return htmlbuilder;
	}
	
	
	
	

}
