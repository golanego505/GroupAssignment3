package mylittlemozart.factory;

/**
 * {@inheritDoc}
 */
public class LegatoMidiEventFactoryAbstract implements MidiEventFactoryAbstract {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public MidiEventFactory createFactory() {
		return new LegatoMidiEventFactory();
	}

}
