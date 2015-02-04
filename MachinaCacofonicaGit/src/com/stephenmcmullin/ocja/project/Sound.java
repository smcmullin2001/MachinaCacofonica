/* Generates the sound */

package com.stephenmcmullin.ocja.project;

import jm.JMC;
import jm.music.data.CPhrase;
import jm.music.data.Part;
import jm.music.data.Phrase;
import jm.music.data.Score;
import jm.music.tools.Mod;

import java.util.Random;

public class Sound implements JMC{

	static int duration = 1;
	static boolean isPlaying;
	@SuppressWarnings("unused")
	private NoiseMachineMain nmm;

	public Score setSound(int i){
		
		if(AdvancedScreen.infinite){
			duration = 1000;
		}

		//create a background drone with an array of instruments which are picked at random on each play
		//plays one long note, length depends on number of loops selected.
		int[] droneInstruments = {17,49,52,53,54,72,73,74,75,78,79,82,86,88,89,91,92,94,97};
		Random random = new Random();
		int randomIndex = random.nextInt(droneInstruments.length);
		Part p2 = new Part(droneInstruments[randomIndex], 0);
		CPhrase cpr = new CPhrase(0.0);

		int[] pitchArray = {C3, E3, G3};

		cpr.addChord(pitchArray, SB*24*duration);
		cpr.setDynamic(40);
		p2.addCPhrase(cpr);

		// Create arrays of notes to be played through at random
		
		Phrase melody = new Phrase(0.0);
		
//		Test Melody
//		int[] twinkMel = {C3, C3, G3, G3, A3, A3, G3};
//		double[] twinkRhythm = {HN,HN,HN,HN,HN,HN,SB};
//		
		int[] twinkMel = {A3, B3, C3, D3, E3, F3, G3, A3, B3, C3, D3, E3, F3, G3, A3, B3, C3, D3, E3, F3, G3, A3, B3, 
				C3, D3, E3, F3, G3, A3, B3, C3, D3, E3, F3, G3, A3, B3, C3, D3, E3, F3, G3, A3, B3, C3, D3, E3, F3, G3};
		double[] twinkRhythm = {SB, SB, SB, SB, SB, SB, SB, HN, HN, HN, HN, HN, HN, HN, HN, HN, HN, HN, HN, HN, HN, QN, 
				QN, QN, QN, QN, QN, QN,QN, QN, QN, QN, QN, QN, QN,QN, QN, QN, QN, QN, QN, QN,QN, QN, QN, QN, QN, QN, QN };

		melody.addNoteList(twinkMel, twinkRhythm);
		Part sound = new Part("Sample", i, 2);
		sound.addPhrase(melody);
		Mod.shuffle(sound);
		sound.setDynamic(60);
		
		Mod.repeat(sound, duration);
		
		
		Score comp = new Score(60);
		comp.addPart(sound);
		comp.addPart(p2);
		if(AdvancedScreen.keyChange){
			transposeComp(comp, AdvancedScreen.newKey);
		}
		//Prints info to console for testing purposes - 
		//some of the drones are horrible, this will help weed them out.
//		System.out.println(randomIndex);
//		System.out.println(droneInstruments.length);
//		System.out.println(droneInstruments[randomIndex]);
		return comp;
	}
	//Method for transposing sound
	public void transposeComp(Score comp, int key){
		Mod.transpose(comp, 2, MAJOR_SCALE, key);
	}
}
