package mylittlemozart.strategies.pitch;

/**
 * A pitch strategy that decreases the pitch by two semitones. 
 * 
 * @see PitchStrategy
 */
public class LowerPitchStrategy implements PitchStrategy{

	/**
	 * Decreases the given note by two semitones.
	 * 
	 * @param note the original MIDI note number
	 * @return the modified note number, decreased by 2
	 */
	@Override
	public int modifyPitch(int note) {
		return note - 2;
	}
	
}
