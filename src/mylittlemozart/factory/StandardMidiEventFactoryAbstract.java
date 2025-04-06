package mylittlemozart.factory;

/**
 * {@inheritDoc}
 */
public class StandardMidiEventFactoryAbstract implements MidiEventFactoryAbstract {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public MidiEventFactory createFactory() {
		 return new StandardMidiEventFactory();
	}
}
