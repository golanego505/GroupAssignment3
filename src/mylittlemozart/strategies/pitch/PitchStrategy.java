package mylittlemozart.strategies.pitch;

/**
 * Strategy for applying a pitch change
 */
public interface PitchStrategy {
	
	/**
	 * Applies a change of pitch to a given note from a MidiEvent.
	 * 
	 * @param note The original MIDI note number.
	 * @return The note number after being modified.
	 */
	int modifyPitch(int note);

}
