package proj0;
import java.util.*;

/** Creating Planet Class*/
public class Planet {
	double xxPos;
	double yyPos;
	double xxVel;
	double yyVel;
	double mass;
	String imgFileName;
	
	public Planet(double xxPos,double yyPos,double xxVel,double yyVel,double mass,String imgFileName) {
		this.xxPos = xxPos;
		this.yyPos = yyPos;
		this.xxVel = xxVel;
		this.yyVel = yyVel;
		this.mass = mass;
		this.imgFileName = imgFileName;
	}
	public Planet(Planet aPlanet) {
		this.xxPos = aPlanet.xxPos;
		this.yyPos = aPlanet.yyPos;
		this.xxVel = aPlanet.xxVel;
		this.yyVel = aPlanet.yyVel;
		this.mass = aPlanet.mass;
		this.imgFileName = aPlanet.imgFileName;
	}
}
