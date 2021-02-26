// Generated from /media/itviewer/linux/easysoc/easysoc-diagrammer/src/main/antlr/ElktLanguage.g4 by ANTLR 4.8
package org.easysoc.plugins.diagrammer.parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ElktLanguageLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		Key_node=10, Key_label=11, Key_port=12, Key_edge=13, Key_layout=14, Key_size=15, 
		Key_section=16, Key_incoming=17, Key_outgoing=18, Key_start=19, Key_end=20, 
		Key_bends=21, BooleanValue=22, QualifiedId=23, StringLit=24, Number=25, 
		DoubleLit=26, UnsignedInt=27, SignedInt=28, COMMENT=29, WHITESPACE=30, 
		NEWLINE=31, ERRCHAR=32;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"Key_node", "Key_label", "Key_port", "Key_edge", "Key_layout", "Key_size", 
			"Key_section", "Key_incoming", "Key_outgoing", "Key_start", "Key_end", 
			"Key_bends", "BooleanValue", "QualifiedId", "StringLit", "UnquotedString", 
			"Id", "Number", "DoubleLit", "UnsignedInt", "SignedInt", "PosInt", "Digit", 
			"LegalIdChar", "LegalStartChar", "COMMENT", "WHITESPACE", "NEWLINE", 
			"ERRCHAR"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'['", "'position'", "':'", "','", "']'", "'null'", "'{'", "'}'", 
			"'->'", "'node'", "'label'", "'port'", "'edge'", "'layout'", "'size'", 
			"'section'", "'incoming'", "'outgoing'", "'start'", "'end'", "'bends'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, "Key_node", 
			"Key_label", "Key_port", "Key_edge", "Key_layout", "Key_size", "Key_section", 
			"Key_incoming", "Key_outgoing", "Key_start", "Key_end", "Key_bends", 
			"BooleanValue", "QualifiedId", "StringLit", "Number", "DoubleLit", "UnsignedInt", 
			"SignedInt", "COMMENT", "WHITESPACE", "NEWLINE", "ERRCHAR"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public ElktLanguageLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "ElktLanguage.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\"\u0138\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\3\2\3\2\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b"+
		"\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25"+
		"\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\5\27\u00c1\n\27\3\30\3\30\3\30\7\30\u00c6\n\30\f\30\16\30\u00c9"+
		"\13\30\3\31\3\31\5\31\u00cd\n\31\3\31\3\31\3\32\6\32\u00d2\n\32\r\32\16"+
		"\32\u00d3\3\33\3\33\7\33\u00d8\n\33\f\33\16\33\u00db\13\33\3\34\3\34\3"+
		"\34\5\34\u00e0\n\34\3\35\5\35\u00e3\n\35\3\35\6\35\u00e6\n\35\r\35\16"+
		"\35\u00e7\3\35\3\35\6\35\u00ec\n\35\r\35\16\35\u00ed\3\35\3\35\5\35\u00f2"+
		"\n\35\3\35\6\35\u00f5\n\35\r\35\16\35\u00f6\5\35\u00f9\n\35\3\36\3\36"+
		"\5\36\u00fd\n\36\3\37\3\37\3\37\3 \3 \7 \u0104\n \f \16 \u0107\13 \3!"+
		"\3!\3\"\3\"\3\"\5\"\u010e\n\"\3#\3#\3$\3$\3$\3$\7$\u0116\n$\f$\16$\u0119"+
		"\13$\3$\6$\u011c\n$\r$\16$\u011d\3$\3$\3%\6%\u0123\n%\r%\16%\u0124\3%"+
		"\3%\3&\5&\u012a\n&\3&\3&\7&\u012e\n&\f&\16&\u0131\13&\3&\3&\3\'\3\'\3"+
		"\'\3\'\4\u00d3\u0117\2(\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f"+
		"\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63"+
		"\2\65\2\67\339\34;\35=\36?\2A\2C\2E\2G\37I K!M\"\3\2\b\4\2\f\f\17\17\4"+
		"\2--//\3\2\63;\3\2\62;\5\2C\\aac|\4\2\13\13\"\"\2\u0147\2\3\3\2\2\2\2"+
		"\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2"+
		"\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2"+
		"\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2"+
		"\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2"+
		"\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2"+
		"K\3\2\2\2\2M\3\2\2\2\3O\3\2\2\2\5Q\3\2\2\2\7Z\3\2\2\2\t\\\3\2\2\2\13^"+
		"\3\2\2\2\r`\3\2\2\2\17e\3\2\2\2\21g\3\2\2\2\23i\3\2\2\2\25l\3\2\2\2\27"+
		"q\3\2\2\2\31w\3\2\2\2\33|\3\2\2\2\35\u0081\3\2\2\2\37\u0088\3\2\2\2!\u008d"+
		"\3\2\2\2#\u0095\3\2\2\2%\u009e\3\2\2\2\'\u00a7\3\2\2\2)\u00ad\3\2\2\2"+
		"+\u00b1\3\2\2\2-\u00c0\3\2\2\2/\u00c2\3\2\2\2\61\u00ca\3\2\2\2\63\u00d1"+
		"\3\2\2\2\65\u00d5\3\2\2\2\67\u00df\3\2\2\29\u00e2\3\2\2\2;\u00fc\3\2\2"+
		"\2=\u00fe\3\2\2\2?\u0101\3\2\2\2A\u0108\3\2\2\2C\u010d\3\2\2\2E\u010f"+
		"\3\2\2\2G\u0111\3\2\2\2I\u0122\3\2\2\2K\u0129\3\2\2\2M\u0134\3\2\2\2O"+
		"P\7]\2\2P\4\3\2\2\2QR\7r\2\2RS\7q\2\2ST\7u\2\2TU\7k\2\2UV\7v\2\2VW\7k"+
		"\2\2WX\7q\2\2XY\7p\2\2Y\6\3\2\2\2Z[\7<\2\2[\b\3\2\2\2\\]\7.\2\2]\n\3\2"+
		"\2\2^_\7_\2\2_\f\3\2\2\2`a\7p\2\2ab\7w\2\2bc\7n\2\2cd\7n\2\2d\16\3\2\2"+
		"\2ef\7}\2\2f\20\3\2\2\2gh\7\177\2\2h\22\3\2\2\2ij\7/\2\2jk\7@\2\2k\24"+
		"\3\2\2\2lm\7p\2\2mn\7q\2\2no\7f\2\2op\7g\2\2p\26\3\2\2\2qr\7n\2\2rs\7"+
		"c\2\2st\7d\2\2tu\7g\2\2uv\7n\2\2v\30\3\2\2\2wx\7r\2\2xy\7q\2\2yz\7t\2"+
		"\2z{\7v\2\2{\32\3\2\2\2|}\7g\2\2}~\7f\2\2~\177\7i\2\2\177\u0080\7g\2\2"+
		"\u0080\34\3\2\2\2\u0081\u0082\7n\2\2\u0082\u0083\7c\2\2\u0083\u0084\7"+
		"{\2\2\u0084\u0085\7q\2\2\u0085\u0086\7w\2\2\u0086\u0087\7v\2\2\u0087\36"+
		"\3\2\2\2\u0088\u0089\7u\2\2\u0089\u008a\7k\2\2\u008a\u008b\7|\2\2\u008b"+
		"\u008c\7g\2\2\u008c \3\2\2\2\u008d\u008e\7u\2\2\u008e\u008f\7g\2\2\u008f"+
		"\u0090\7e\2\2\u0090\u0091\7v\2\2\u0091\u0092\7k\2\2\u0092\u0093\7q\2\2"+
		"\u0093\u0094\7p\2\2\u0094\"\3\2\2\2\u0095\u0096\7k\2\2\u0096\u0097\7p"+
		"\2\2\u0097\u0098\7e\2\2\u0098\u0099\7q\2\2\u0099\u009a\7o\2\2\u009a\u009b"+
		"\7k\2\2\u009b\u009c\7p\2\2\u009c\u009d\7i\2\2\u009d$\3\2\2\2\u009e\u009f"+
		"\7q\2\2\u009f\u00a0\7w\2\2\u00a0\u00a1\7v\2\2\u00a1\u00a2\7i\2\2\u00a2"+
		"\u00a3\7q\2\2\u00a3\u00a4\7k\2\2\u00a4\u00a5\7p\2\2\u00a5\u00a6\7i\2\2"+
		"\u00a6&\3\2\2\2\u00a7\u00a8\7u\2\2\u00a8\u00a9\7v\2\2\u00a9\u00aa\7c\2"+
		"\2\u00aa\u00ab\7t\2\2\u00ab\u00ac\7v\2\2\u00ac(\3\2\2\2\u00ad\u00ae\7"+
		"g\2\2\u00ae\u00af\7p\2\2\u00af\u00b0\7f\2\2\u00b0*\3\2\2\2\u00b1\u00b2"+
		"\7d\2\2\u00b2\u00b3\7g\2\2\u00b3\u00b4\7p\2\2\u00b4\u00b5\7f\2\2\u00b5"+
		"\u00b6\7u\2\2\u00b6,\3\2\2\2\u00b7\u00b8\7v\2\2\u00b8\u00b9\7t\2\2\u00b9"+
		"\u00ba\7w\2\2\u00ba\u00c1\7g\2\2\u00bb\u00bc\7h\2\2\u00bc\u00bd\7c\2\2"+
		"\u00bd\u00be\7n\2\2\u00be\u00bf\7u\2\2\u00bf\u00c1\7g\2\2\u00c0\u00b7"+
		"\3\2\2\2\u00c0\u00bb\3\2\2\2\u00c1.\3\2\2\2\u00c2\u00c7\5\65\33\2\u00c3"+
		"\u00c4\7\60\2\2\u00c4\u00c6\5\65\33\2\u00c5\u00c3\3\2\2\2\u00c6\u00c9"+
		"\3\2\2\2\u00c7\u00c5\3\2\2\2\u00c7\u00c8\3\2\2\2\u00c8\60\3\2\2\2\u00c9"+
		"\u00c7\3\2\2\2\u00ca\u00cc\7$\2\2\u00cb\u00cd\5\63\32\2\u00cc\u00cb\3"+
		"\2\2\2\u00cc\u00cd\3\2\2\2\u00cd\u00ce\3\2\2\2\u00ce\u00cf\7$\2\2\u00cf"+
		"\62\3\2\2\2\u00d0\u00d2\n\2\2\2\u00d1\u00d0\3\2\2\2\u00d2\u00d3\3\2\2"+
		"\2\u00d3\u00d4\3\2\2\2\u00d3\u00d1\3\2\2\2\u00d4\64\3\2\2\2\u00d5\u00d9"+
		"\5E#\2\u00d6\u00d8\5C\"\2\u00d7\u00d6\3\2\2\2\u00d8\u00db\3\2\2\2\u00d9"+
		"\u00d7\3\2\2\2\u00d9\u00da\3\2\2\2\u00da\66\3\2\2\2\u00db\u00d9\3\2\2"+
		"\2\u00dc\u00e0\5;\36\2\u00dd\u00e0\5=\37\2\u00de\u00e0\59\35\2\u00df\u00dc"+
		"\3\2\2\2\u00df\u00dd\3\2\2\2\u00df\u00de\3\2\2\2\u00e08\3\2\2\2\u00e1"+
		"\u00e3\t\3\2\2\u00e2\u00e1\3\2\2\2\u00e2\u00e3\3\2\2\2\u00e3\u00e5\3\2"+
		"\2\2\u00e4\u00e6\5A!\2\u00e5\u00e4\3\2\2\2\u00e6\u00e7\3\2\2\2\u00e7\u00e5"+
		"\3\2\2\2\u00e7\u00e8\3\2\2\2\u00e8\u00e9\3\2\2\2\u00e9\u00eb\7\60\2\2"+
		"\u00ea\u00ec\5A!\2\u00eb\u00ea\3\2\2\2\u00ec\u00ed\3\2\2\2\u00ed\u00eb"+
		"\3\2\2\2\u00ed\u00ee\3\2\2\2\u00ee\u00f8\3\2\2\2\u00ef\u00f1\7G\2\2\u00f0"+
		"\u00f2\t\3\2\2\u00f1\u00f0\3\2\2\2\u00f1\u00f2\3\2\2\2\u00f2\u00f4\3\2"+
		"\2\2\u00f3\u00f5\5A!\2\u00f4\u00f3\3\2\2\2\u00f5\u00f6\3\2\2\2\u00f6\u00f4"+
		"\3\2\2\2\u00f6\u00f7\3\2\2\2\u00f7\u00f9\3\2\2\2\u00f8\u00ef\3\2\2\2\u00f8"+
		"\u00f9\3\2\2\2\u00f9:\3\2\2\2\u00fa\u00fd\7\62\2\2\u00fb\u00fd\5? \2\u00fc"+
		"\u00fa\3\2\2\2\u00fc\u00fb\3\2\2\2\u00fd<\3\2\2\2\u00fe\u00ff\t\3\2\2"+
		"\u00ff\u0100\5? \2\u0100>\3\2\2\2\u0101\u0105\t\4\2\2\u0102\u0104\5A!"+
		"\2\u0103\u0102\3\2\2\2\u0104\u0107\3\2\2\2\u0105\u0103\3\2\2\2\u0105\u0106"+
		"\3\2\2\2\u0106@\3\2\2\2\u0107\u0105\3\2\2\2\u0108\u0109\t\5\2\2\u0109"+
		"B\3\2\2\2\u010a\u010e\5E#\2\u010b\u010e\5A!\2\u010c\u010e\7&\2\2\u010d"+
		"\u010a\3\2\2\2\u010d\u010b\3\2\2\2\u010d\u010c\3\2\2\2\u010eD\3\2\2\2"+
		"\u010f\u0110\t\6\2\2\u0110F\3\2\2\2\u0111\u0112\7\61\2\2\u0112\u0113\7"+
		"\61\2\2\u0113\u0117\3\2\2\2\u0114\u0116\13\2\2\2\u0115\u0114\3\2\2\2\u0116"+
		"\u0119\3\2\2\2\u0117\u0118\3\2\2\2\u0117\u0115\3\2\2\2\u0118\u011b\3\2"+
		"\2\2\u0119\u0117\3\2\2\2\u011a\u011c\7\f\2\2\u011b\u011a\3\2\2\2\u011c"+
		"\u011d\3\2\2\2\u011d\u011b\3\2\2\2\u011d\u011e\3\2\2\2\u011e\u011f\3\2"+
		"\2\2\u011f\u0120\b$\2\2\u0120H\3\2\2\2\u0121\u0123\t\7\2\2\u0122\u0121"+
		"\3\2\2\2\u0123\u0124\3\2\2\2\u0124\u0122\3\2\2\2\u0124\u0125\3\2\2\2\u0125"+
		"\u0126\3\2\2\2\u0126\u0127\b%\2\2\u0127J\3\2\2\2\u0128\u012a\7\17\2\2"+
		"\u0129\u0128\3\2\2\2\u0129\u012a\3\2\2\2\u012a\u012b\3\2\2\2\u012b\u012f"+
		"\7\f\2\2\u012c\u012e\7\"\2\2\u012d\u012c\3\2\2\2\u012e\u0131\3\2\2\2\u012f"+
		"\u012d\3\2\2\2\u012f\u0130\3\2\2\2\u0130\u0132\3\2\2\2\u0131\u012f\3\2"+
		"\2\2\u0132\u0133\b&\2\2\u0133L\3\2\2\2\u0134\u0135\13\2\2\2\u0135\u0136"+
		"\3\2\2\2\u0136\u0137\b\'\2\2\u0137N\3\2\2\2\27\2\u00c0\u00c7\u00cc\u00d3"+
		"\u00d9\u00df\u00e2\u00e7\u00ed\u00f1\u00f6\u00f8\u00fc\u0105\u010d\u0117"+
		"\u011d\u0124\u0129\u012f\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}