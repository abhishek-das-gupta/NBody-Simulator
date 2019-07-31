import java.util.*;
// import Planet.java;
public class NBody{

	public static double readRadius(String afile){
		In in = new In(afile);
		int numberOfPlanets = in.readInt();
		double radius = in.readDouble();
		return radius;
	}

	public static Planet[] readPlanets(String afile){
		In in = new In(afile);
		in.readInt();
		in.readDouble();

		Planet[] allPlanets = new Planet[5];
		for(int i = 0; i < allPlanets.length; i++){
			double xxPos = in.readDouble();
			double yyPos = in.readDouble();
			double xxVel = in.readDouble();
			double yyVel = in.readDouble();
			double mass = in.readDouble();
			String name = in.readString();

			Planet aPlanet = new Planet(xxPos,yyPos,xxVel,yyVel,mass,name);
			allPlanets[i] = aPlanet;

		}
		return allPlanets;
	}

	public static void main(String[] args){
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		double radiusOfUniverse = readRadius(filename);
		Planet[] allPlanets = readPlanets(filename);

		String imageToDraw = "images/starfield.jpg";
		StdDraw.setScale(-2 * radiusOfUniverse, 2 * radiusOfUniverse);
		StdDraw.picture(0, 0, imageToDraw);
		StdDraw.show();

		for(Planet aPlanet : allPlanets){
			aPlanet.draw();
		}

		/** prevent flickering in the animation*/
		StdDraw.enableDoubleBuffering();

		int atime = 0;
		while (atime != T){
			Double[] xForces = new Double[allPlanets.length];
			Double[] yForces = new Double[allPlanets.length];

			for(int i=0; i < allPlanets.length; i++){
				Planet aPlanet = allPlanets[i];
				xForces[i] = aPlanet.calcNetForceExertedByX(allPlanets);
				yForces[i] = aPlanet.calcNetForceExertedByY(allPlanets);

				aPlanet.update(atime, xForces[i], yForces[i]);
			}

			StdDraw.picture(0, 0, imageToDraw);
			StdDraw.show();
			for(Planet aPlanet: allPlanets)
				aPlanet.draw();

			StdDraw.pause(200);

			atime += dt;
		}


	}

}