package mylittlemozart.factory;

/**
 * Abstract factory interface for creating MidiEventFactory objects
 * Returns Standard, Staccato, and Legato MidiEventFactory objects
 */
public interface MidiEventFactoryAbstract {
	/**
	 * Creates and returns instance of MidiEventFactory objects
	 * @return		MidiEventFactoryObjects
	 */
	 MidiEventFactory createFactory();
	 
}
