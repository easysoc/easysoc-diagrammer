package org.easysoc.plugins.diagrammer.highlight;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.tree.IElementType;
import org.antlr.intellij.adaptor.lexer.ANTLRLexerAdaptor;
import org.antlr.intellij.adaptor.lexer.PSIElementTypeFactory;
import org.antlr.intellij.adaptor.lexer.TokenIElementType;
import org.easysoc.plugins.diagrammer.ElktLanguage;
import org.easysoc.plugins.diagrammer.parser.ElktLanguageLexer;
import org.easysoc.plugins.diagrammer.parser.ElktLanguageParser;
import org.jetbrains.annotations.NotNull;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

/** A highlighter is really just a mapping from token type to
 *  some text attributes using {@link #getTokenHighlights(IElementType)}.
 *  The reason that it returns an array, TextAttributesKey[], is
 *  that you might want to mix the attributes of a few known highlighters.
 *  A {@link TextAttributesKey} is just a name for that a theme
 *  or IDE skin can set. For example, {@link DefaultLanguageHighlighterColors#KEYWORD}
 *  is the key that maps to what identifiers look like in the editor.
 *  To change it, see dialog: Editor > Colors & Fonts > Language Defaults.
 *
 *  From <a href="http://www.jetbrains.org/intellij/sdk/docs/reference_guide/custom_language_support/syntax_highlighting_and_error_highlighting.html">doc</a>:
 *  "The mapping of the TextAttributesKey to specific attributes used
 *  in an editor is defined by the EditorColorsScheme class, and can
 *  be configured by the user if the plugin provides an appropriate
 *  configuration interface.
 *  ...
 *  The syntax highlighter returns the {@link TextAttributesKey}
 * instances for each token type which needs special highlighting.
 * For highlighting lexer errors, the standard TextAttributesKey
 * for bad characters HighlighterColors.BAD_CHARACTER can be used."
 */
public class ElktSyntaxHighlighter extends SyntaxHighlighterBase {
	private static final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[0];

	public static final TextAttributesKey ID =
					createTextAttributesKey("ID", DefaultLanguageHighlighterColors.IDENTIFIER);
	public static final TextAttributesKey KEYWORD =
					createTextAttributesKey("KEYWORD", DefaultLanguageHighlighterColors.KEYWORD);
	public static final TextAttributesKey STRING =
					createTextAttributesKey("STRING", DefaultLanguageHighlighterColors.STRING);
	public static final TextAttributesKey LINE_COMMENT =
					createTextAttributesKey("LINE_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);

	// maps all tokens and rule names into IElementType objects: {@link TokenIElementType} and {@link RuleIElementType}
	static {
		PSIElementTypeFactory.defineLanguageIElementTypes(ElktLanguage.INSTANCE,
						ElktLanguageParser.tokenNames,
						ElktLanguageParser.ruleNames);
	}

	@NotNull
	@Override
	public Lexer getHighlightingLexer() {
		ElktLanguageLexer lexer = new ElktLanguageLexer(null);
		return new ANTLRLexerAdaptor(ElktLanguage.INSTANCE, lexer);
	}

	@NotNull
	@Override
	public TextAttributesKey[] getTokenHighlights(IElementType tokenType) {
//		List<TokenIElementType> list = PSIElementTypeFactory.getTokenIElementTypes(SampleLanguage.INSTANCE);
//		if ( !(tokenType instanceof TokenIElementType) ) return EMPTY_KEYS;
		TokenIElementType myType = (TokenIElementType)tokenType;
		int tokentype = myType.getANTLRTokenType();
		TextAttributesKey attrKey;
		// compare with IntStream
		switch ( tokentype ) {
			case ElktLanguageLexer.QualifiedId :
				attrKey = ID;
				break;
			case ElktLanguageLexer.Key_node :
			case ElktLanguageLexer.Key_label :
			case ElktLanguageLexer.Key_port :
			case ElktLanguageLexer.Key_edge :
			case ElktLanguageLexer.Key_layout :
			case ElktLanguageLexer.Key_size :
			case ElktLanguageLexer.Key_section :
			case ElktLanguageLexer.Key_incoming :
			case ElktLanguageLexer.Key_outgoing :
			case ElktLanguageLexer.Key_start :
			case ElktLanguageLexer.Key_end :
			case ElktLanguageLexer.Key_bends :
				attrKey = KEYWORD;
				break;
			case ElktLanguageLexer.StringLit :
				attrKey = STRING;
				break;
			case ElktLanguageLexer.COMMENT :
				attrKey = LINE_COMMENT;
				break;
			default :
				return EMPTY_KEYS;
		}
		return new TextAttributesKey[] {attrKey};
	}
}
