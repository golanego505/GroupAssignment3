package mylittlemozart.parser;

/**
 * Represents a MIDI event extracted from a CSV file.
 * Store the tick timing, velocity, pitch, channel, instrument, and note state
 */
public class MidiEventData {
	
	private int startEndTick, velocity, note, channel, noteOnOff;
	private int instrument;
	
	/**
	 * Constructs a new MidiEventData objects.
	 * 
	 * @param startEndTick The tick number at which the note event occurs, start or end.
	 * @param velocity     The volume of the note.
	 * @param note         The pitch of the note.
	 * @param channel      The MIDI channel the event belongs too
	 * @param instrument   The instrument number
	 * @param noteOnOff    Indicates if the note is being played (ShortMessage.NOTE_ON or ShortMessage.NOTE_OFF)
	 */
	public MidiEventData(int startEndTick, int velocity, int note,
	                     int channel, int instrument, int noteOnOff) {
	    this.startEndTick = startEndTick;
	    this.velocity = velocity;
	    this.note = note;
	    this.channel = channel;
	    this.instrument = instrument;
	    this.noteOnOff = noteOnOff;
	}
	
	/**
	 * Gets the tick at which this MIDI event occurs.
	 * @return The tick value.
	 */
	public int getStartEndTick() {
		return startEndTick;
	}
	
	/**
	 * Sets the tick value.
	 * @param startEndTick The new tick value.
	 */
	public void setStartEndTick(int startEndTick) {
		this.startEndTick = startEndTick;
	}

	/**
	 * Gets the velocity at which this MIDI event occurs.
	 * @return The velocity value.
	 */
	public int getVelocity() {
		return velocity;
	}

	/**
	 * Sets the velocity value.
	 * @param velocity The new velocity value.
	 */
	public void setVelocity(int velocity) {
		this.velocity = velocity;
	}

	/**
	 * Gets the note at which the event occurs.
	 * @return The note value.
	 */
	public int getNote() {
		return note;
	}

	/**
	 * Sets the note value.
	 * @param note The new note value.
	 */
	public void setNote(int note) {
		this.note = note;
	}

	/**
	 * Gets the channel value at which the event occurs.
	 * @return The channel value.
	 */
	public int getChannel() {
		return channel;
	}

	/**
	 * Sets the channel value.
	 * @param channel The new channel value.
	 */
	public void setChannel(int channel) {
		this.channel = channel;
	}

	/**
	 * Gets the note byte value for NOTE_ON or NOTE_OFF at which the event occurs.
	 * @return The byte value
	 */
	public int getNoteOnOff() {
		return noteOnOff;
	}

	/**
	 * Sets the NOTE_ON or NOTE_OFF value using ShortMessage.
	 * @param noteOnOff The byte value.
	 */
	public void setNoteOnOff(int noteOnOff) {
		this.noteOnOff = noteOnOff;
	}

	/**
	 * Gets the instrument number.
	 * @return The instrument number.
	 */
	public int getInstrument() {
		return instrument;
	}

	/**
	 * Sets the instrument number.
	 * @param instrument The new instrument number.
	 */
	public void setInstrument(int instrument) {
		this.instrument = instrument;
	}
	
	@Override
	public String toString() {
	    return "MidiEventData {" +
	           "startEndTick=" + startEndTick +
	           ", velocity=" + velocity +
	           ", note=" + note +
	           ", channel=" + channel +
	           ", instrument=" + instrument +
	           ", noteOnOff=" + (noteOnOff == 0x90 ? "NOTE_ON" : noteOnOff == 0x80 ? "NOTE_OFF" : noteOnOff) +
	           "}";
	}
}
