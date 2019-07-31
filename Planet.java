//package proj0;
import java.util.*;

/** Creating Planet Class*/
public class Planet {
	double xxPos;
	double yyPos;
	double xxVel;
	double yyVel;
	double mass;
	String imgFileName;
	double G = 6.67e-11;

	
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
	
	public double calcDistance(Planet aPlanet) {
		double xxDiff = this.xxPos - aPlanet.xxPos;
		double yyDiff = this.yyPos - aPlanet.yyPos;
		double aDist =  Math.sqrt(xxDiff*xxDiff + yyDiff*yyDiff);
		return aDist;
	}

	public double calcForceExertedBy(Planet aPlanet){
		double m1 = this.mass;
		double m2 = aPlanet.mass;
	    double r = aPlanet.calcDistance(this);
	    double F = (G * m1 * m2)/(r * r);
	    return F;
	}
	public double calcForceExertedByX(Planet aPlanet)
	{
	    double r = aPlanet.calcDistance(this);
	    double F = this.calcForceExertedBy(aPlanet);
	    double dx = aPlanet.xxPos - this.xxPos;
	    double F_x = (F * dx)/r;
	    return F_x;
	}
	public double calcForceExertedByY(Planet aPlanet)
	{
	    double r = aPlanet.calcDistance(this);
	    double F = this.calcForceExertedBy(aPlanet);
	    double dy = aPlanet.yyPos - this.yyPos;
	    double F_y = (F * dy)/r;
	    return F_y;
	}

	public double calcNetForceExertedByX(Planet[] allPlanets){
		double netForceX = 0.0;
		for(Planet aPlanet : allPlanets){
			if(this.equals(aPlanet))
				continue;
			double F_x = this.calcForceExertedByX(aPlanet);
			netForceX += F_x;
		}
		return netForceX;
	}

	public double calcNetForceExertedByY(Planet[] allPlanets){
		double netForceY = 0.0;
		for(Planet aPlanet : allPlanets){
			if(this.equals(aPlanet))
				continue;
			double F_y = this.calcForceExertedByY(aPlanet);
			netForceY += F_y;
		}
		return netForceY;
	}

	public void update(double dt, double fX, double fY){
		double m = this.mass;
		double uX = this.xxVel;
		double uY = this.yyVel;
		double pX = this.xxPos;
		double pY = this.yyPos;

		double aX = fX / m;
		double aY = fY / m;

		this.xxVel = uX + aX * dt;
		this.yyVel = uY + aY * dt;

		double vX = this.xxVel;
		double vY = this.yyVel;

		this.xxPos = pX + vX * dt;
		this.yyPos = pY + vY * dt;
	}

	public void draw(){
		String imageToDraw = this.imgFileName;
		imageToDraw = "images/" + imageToDraw;
		StdDraw.picture(this.xxPos, this.yyPos, imageToDraw);
		StdDraw.show();
	}
	
}
