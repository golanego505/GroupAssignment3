package mylittlemozart.strategies.pitch;

/**
 * A pitch strategy that increases the pitch by two semitones. 
 * 
 * @see PitchStrategy
 */
public class HigherPitchStrategy implements PitchStrategy{
	
	/**
	 * Increases the given note by two semitones.
	 * 
	 * @param note the original MIDI note number
	 * @return the modified note number, increased by 2
	 */
	@Override
	public int modifyPitch(int note) {
		return note + 2;
	}
	
}
