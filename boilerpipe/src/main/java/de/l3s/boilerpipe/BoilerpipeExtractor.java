package de.l3s.boilerpipe;

import de.l3s.boilerpipe.document.TextDocument;
import org.xml.sax.InputSource;

import java.io.Reader;

/**
 * Describes a complete filter pipeline.
 * 
 * @author Christian Kohlschütter
 */
public interface BoilerpipeExtractor extends BoilerpipeFilter {
    /**
     * Extracts text from the HTML code given as a String.
     * 
     * @param html
     *            The HTML code as a String.
     * @return The extracted text.
     * @throws BoilerpipeProcessingException
     */
    public String getText(final String html)
            throws BoilerpipeProcessingException;

    /**
     * Extracts text from the HTML code available from the given
     * {@link org.xml.sax.InputSource}.
     * 
     * @param is
     *            The InputSource containing the HTML
     * @return The extracted text.
     * @throws BoilerpipeProcessingException
     */
    public String getText(final InputSource is)
            throws BoilerpipeProcessingException;

    /**
     * Extracts text from the HTML code available from the given {@link java.io.Reader}.
     * 
     * @param r
     *            The Reader containing the HTML
     * @return The extracted text.
     * @throws BoilerpipeProcessingException
     */
    public String getText(final Reader r) throws BoilerpipeProcessingException;

    /**
     * Extracts text from the given {@link TextDocument} object.
     * 
     * @param doc
     *            The {@link TextDocument}.
     * @return The extracted text.
     * @throws BoilerpipeProcessingException
     */
    public String getText(TextDocument doc)
            throws BoilerpipeProcessingException;
}
