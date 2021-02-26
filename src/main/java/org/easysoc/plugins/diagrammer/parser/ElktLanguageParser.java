// Generated from /media/itviewer/linux/easysoc/easysoc-diagrammer/src/main/antlr/ElktLanguage.g4 by ANTLR 4.8
package org.easysoc.plugins.diagrammer.parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ElktLanguageParser extends Parser {
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
	public static final int
		RULE_graph = 0, RULE_layout = 1, RULE_property = 2, RULE_propertyKey = 3, 
		RULE_propertyValue = 4, RULE_node = 5, RULE_port = 6, RULE_label = 7, 
		RULE_edge = 8;
	private static String[] makeRuleNames() {
		return new String[] {
			"graph", "layout", "property", "propertyKey", "propertyValue", "node", 
			"port", "label", "edge"
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

	@Override
	public String getGrammarFileName() { return "ElktLanguage.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ElktLanguageParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class GraphContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(ElktLanguageParser.EOF, 0); }
		public LayoutContext layout() {
			return getRuleContext(LayoutContext.class,0);
		}
		public List<PropertyContext> property() {
			return getRuleContexts(PropertyContext.class);
		}
		public PropertyContext property(int i) {
			return getRuleContext(PropertyContext.class,i);
		}
		public List<NodeContext> node() {
			return getRuleContexts(NodeContext.class);
		}
		public NodeContext node(int i) {
			return getRuleContext(NodeContext.class,i);
		}
		public List<EdgeContext> edge() {
			return getRuleContexts(EdgeContext.class);
		}
		public EdgeContext edge(int i) {
			return getRuleContext(EdgeContext.class,i);
		}
		public GraphContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_graph; }
	}

	public final GraphContext graph() throws RecognitionException {
		GraphContext _localctx = new GraphContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_graph);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(19);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Key_layout) {
				{
				setState(18);
				layout();
				}
			}

			setState(24);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==QualifiedId) {
				{
				{
				setState(21);
				property();
				}
				}
				setState(26);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(31);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Key_node || _la==Key_edge) {
				{
				setState(29);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case Key_node:
					{
					setState(27);
					node();
					}
					break;
				case Key_edge:
					{
					setState(28);
					edge();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(33);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(34);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LayoutContext extends ParserRuleContext {
		public Token x;
		public Token y;
		public Token width;
		public Token height;
		public TerminalNode Key_layout() { return getToken(ElktLanguageParser.Key_layout, 0); }
		public TerminalNode Key_size() { return getToken(ElktLanguageParser.Key_size, 0); }
		public List<TerminalNode> Number() { return getTokens(ElktLanguageParser.Number); }
		public TerminalNode Number(int i) {
			return getToken(ElktLanguageParser.Number, i);
		}
		public LayoutContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_layout; }
	}

	public final LayoutContext layout() throws RecognitionException {
		LayoutContext _localctx = new LayoutContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_layout);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(36);
			match(Key_layout);
			setState(37);
			match(T__0);
			{
			setState(43);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(38);
				match(T__1);
				setState(39);
				match(T__2);
				setState(40);
				((LayoutContext)_localctx).x = match(Number);
				setState(41);
				match(T__3);
				setState(42);
				((LayoutContext)_localctx).y = match(Number);
				}
			}

			setState(50);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Key_size) {
				{
				setState(45);
				match(Key_size);
				setState(46);
				match(T__2);
				setState(47);
				((LayoutContext)_localctx).width = match(Number);
				setState(48);
				match(T__3);
				setState(49);
				((LayoutContext)_localctx).height = match(Number);
				}
			}

			}
			setState(52);
			match(T__4);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PropertyContext extends ParserRuleContext {
		public PropertyKeyContext propertyKey() {
			return getRuleContext(PropertyKeyContext.class,0);
		}
		public PropertyValueContext propertyValue() {
			return getRuleContext(PropertyValueContext.class,0);
		}
		public PropertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_property; }
	}

	public final PropertyContext property() throws RecognitionException {
		PropertyContext _localctx = new PropertyContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(54);
			propertyKey();
			setState(55);
			match(T__2);
			setState(56);
			propertyValue();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PropertyKeyContext extends ParserRuleContext {
		public TerminalNode QualifiedId() { return getToken(ElktLanguageParser.QualifiedId, 0); }
		public PropertyKeyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_propertyKey; }
	}

	public final PropertyKeyContext propertyKey() throws RecognitionException {
		PropertyKeyContext _localctx = new PropertyKeyContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_propertyKey);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(58);
			match(QualifiedId);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PropertyValueContext extends ParserRuleContext {
		public TerminalNode StringLit() { return getToken(ElktLanguageParser.StringLit, 0); }
		public TerminalNode QualifiedId() { return getToken(ElktLanguageParser.QualifiedId, 0); }
		public TerminalNode Number() { return getToken(ElktLanguageParser.Number, 0); }
		public TerminalNode BooleanValue() { return getToken(ElktLanguageParser.BooleanValue, 0); }
		public PropertyValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_propertyValue; }
	}

	public final PropertyValueContext propertyValue() throws RecognitionException {
		PropertyValueContext _localctx = new PropertyValueContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_propertyValue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << BooleanValue) | (1L << QualifiedId) | (1L << StringLit) | (1L << Number))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NodeContext extends ParserRuleContext {
		public TerminalNode Key_node() { return getToken(ElktLanguageParser.Key_node, 0); }
		public TerminalNode QualifiedId() { return getToken(ElktLanguageParser.QualifiedId, 0); }
		public LayoutContext layout() {
			return getRuleContext(LayoutContext.class,0);
		}
		public List<PropertyContext> property() {
			return getRuleContexts(PropertyContext.class);
		}
		public PropertyContext property(int i) {
			return getRuleContext(PropertyContext.class,i);
		}
		public List<LabelContext> label() {
			return getRuleContexts(LabelContext.class);
		}
		public LabelContext label(int i) {
			return getRuleContext(LabelContext.class,i);
		}
		public List<PortContext> port() {
			return getRuleContexts(PortContext.class);
		}
		public PortContext port(int i) {
			return getRuleContext(PortContext.class,i);
		}
		public List<EdgeContext> edge() {
			return getRuleContexts(EdgeContext.class);
		}
		public EdgeContext edge(int i) {
			return getRuleContext(EdgeContext.class,i);
		}
		public List<NodeContext> node() {
			return getRuleContexts(NodeContext.class);
		}
		public NodeContext node(int i) {
			return getRuleContext(NodeContext.class,i);
		}
		public NodeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_node; }
	}

	public final NodeContext node() throws RecognitionException {
		NodeContext _localctx = new NodeContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_node);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			match(Key_node);
			setState(63);
			match(QualifiedId);
			setState(84);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(64);
				match(T__6);
				setState(66);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Key_layout) {
					{
					setState(65);
					layout();
					}
				}

				setState(71);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==QualifiedId) {
					{
					{
					setState(68);
					property();
					}
					}
					setState(73);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(80);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Key_node) | (1L << Key_label) | (1L << Key_port) | (1L << Key_edge))) != 0)) {
					{
					setState(78);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case Key_label:
						{
						setState(74);
						label();
						}
						break;
					case Key_port:
						{
						setState(75);
						port();
						}
						break;
					case Key_edge:
						{
						setState(76);
						edge();
						}
						break;
					case Key_node:
						{
						setState(77);
						node();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(82);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(83);
				match(T__7);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PortContext extends ParserRuleContext {
		public TerminalNode Key_port() { return getToken(ElktLanguageParser.Key_port, 0); }
		public TerminalNode QualifiedId() { return getToken(ElktLanguageParser.QualifiedId, 0); }
		public LayoutContext layout() {
			return getRuleContext(LayoutContext.class,0);
		}
		public List<PropertyContext> property() {
			return getRuleContexts(PropertyContext.class);
		}
		public PropertyContext property(int i) {
			return getRuleContext(PropertyContext.class,i);
		}
		public List<LabelContext> label() {
			return getRuleContexts(LabelContext.class);
		}
		public LabelContext label(int i) {
			return getRuleContext(LabelContext.class,i);
		}
		public PortContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_port; }
	}

	public final PortContext port() throws RecognitionException {
		PortContext _localctx = new PortContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_port);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			match(Key_port);
			setState(87);
			match(QualifiedId);
			setState(105);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(88);
				match(T__6);
				setState(90);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Key_layout) {
					{
					setState(89);
					layout();
					}
				}

				setState(95);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==QualifiedId) {
					{
					{
					setState(92);
					property();
					}
					}
					setState(97);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(101);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Key_label) {
					{
					{
					setState(98);
					label();
					}
					}
					setState(103);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(104);
				match(T__7);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LabelContext extends ParserRuleContext {
		public TerminalNode Key_label() { return getToken(ElktLanguageParser.Key_label, 0); }
		public TerminalNode StringLit() { return getToken(ElktLanguageParser.StringLit, 0); }
		public TerminalNode QualifiedId() { return getToken(ElktLanguageParser.QualifiedId, 0); }
		public LayoutContext layout() {
			return getRuleContext(LayoutContext.class,0);
		}
		public List<PropertyContext> property() {
			return getRuleContexts(PropertyContext.class);
		}
		public PropertyContext property(int i) {
			return getRuleContext(PropertyContext.class,i);
		}
		public List<LabelContext> label() {
			return getRuleContexts(LabelContext.class);
		}
		public LabelContext label(int i) {
			return getRuleContext(LabelContext.class,i);
		}
		public LabelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_label; }
	}

	public final LabelContext label() throws RecognitionException {
		LabelContext _localctx = new LabelContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_label);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			match(Key_label);
			setState(110);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==QualifiedId) {
				{
				setState(108);
				match(QualifiedId);
				setState(109);
				match(T__2);
				}
			}

			setState(112);
			match(StringLit);
			setState(130);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(113);
				match(T__6);
				setState(115);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Key_layout) {
					{
					setState(114);
					layout();
					}
				}

				setState(120);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==QualifiedId) {
					{
					{
					setState(117);
					property();
					}
					}
					setState(122);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(126);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Key_label) {
					{
					{
					setState(123);
					label();
					}
					}
					setState(128);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(129);
				match(T__7);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EdgeContext extends ParserRuleContext {
		public TerminalNode Key_edge() { return getToken(ElktLanguageParser.Key_edge, 0); }
		public List<TerminalNode> QualifiedId() { return getTokens(ElktLanguageParser.QualifiedId); }
		public TerminalNode QualifiedId(int i) {
			return getToken(ElktLanguageParser.QualifiedId, i);
		}
		public LayoutContext layout() {
			return getRuleContext(LayoutContext.class,0);
		}
		public List<PropertyContext> property() {
			return getRuleContexts(PropertyContext.class);
		}
		public PropertyContext property(int i) {
			return getRuleContext(PropertyContext.class,i);
		}
		public List<LabelContext> label() {
			return getRuleContexts(LabelContext.class);
		}
		public LabelContext label(int i) {
			return getRuleContext(LabelContext.class,i);
		}
		public EdgeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_edge; }
	}

	public final EdgeContext edge() throws RecognitionException {
		EdgeContext _localctx = new EdgeContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_edge);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
			match(Key_edge);
			setState(135);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				{
				setState(133);
				match(QualifiedId);
				setState(134);
				match(T__2);
				}
				break;
			}
			setState(137);
			match(QualifiedId);
			setState(142);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(138);
				match(T__3);
				setState(139);
				match(QualifiedId);
				}
				}
				setState(144);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(145);
			match(T__8);
			setState(146);
			match(QualifiedId);
			setState(151);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(147);
				match(T__3);
				setState(148);
				match(QualifiedId);
				}
				}
				setState(153);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(171);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(154);
				match(T__6);
				setState(156);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Key_layout) {
					{
					setState(155);
					layout();
					}
				}

				setState(161);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==QualifiedId) {
					{
					{
					setState(158);
					property();
					}
					}
					setState(163);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(167);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Key_label) {
					{
					{
					setState(164);
					label();
					}
					}
					setState(169);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(170);
				match(T__7);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\"\u00b0\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3\2\5\2"+
		"\26\n\2\3\2\7\2\31\n\2\f\2\16\2\34\13\2\3\2\3\2\7\2 \n\2\f\2\16\2#\13"+
		"\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3.\n\3\3\3\3\3\3\3\3\3\3\3\5"+
		"\3\65\n\3\3\3\3\3\3\4\3\4\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\7\5\7"+
		"E\n\7\3\7\7\7H\n\7\f\7\16\7K\13\7\3\7\3\7\3\7\3\7\7\7Q\n\7\f\7\16\7T\13"+
		"\7\3\7\5\7W\n\7\3\b\3\b\3\b\3\b\5\b]\n\b\3\b\7\b`\n\b\f\b\16\bc\13\b\3"+
		"\b\7\bf\n\b\f\b\16\bi\13\b\3\b\5\bl\n\b\3\t\3\t\3\t\5\tq\n\t\3\t\3\t\3"+
		"\t\5\tv\n\t\3\t\7\ty\n\t\f\t\16\t|\13\t\3\t\7\t\177\n\t\f\t\16\t\u0082"+
		"\13\t\3\t\5\t\u0085\n\t\3\n\3\n\3\n\5\n\u008a\n\n\3\n\3\n\3\n\7\n\u008f"+
		"\n\n\f\n\16\n\u0092\13\n\3\n\3\n\3\n\3\n\7\n\u0098\n\n\f\n\16\n\u009b"+
		"\13\n\3\n\3\n\5\n\u009f\n\n\3\n\7\n\u00a2\n\n\f\n\16\n\u00a5\13\n\3\n"+
		"\7\n\u00a8\n\n\f\n\16\n\u00ab\13\n\3\n\5\n\u00ae\n\n\3\n\2\2\13\2\4\6"+
		"\b\n\f\16\20\22\2\3\4\2\b\b\30\33\2\u00c3\2\25\3\2\2\2\4&\3\2\2\2\68\3"+
		"\2\2\2\b<\3\2\2\2\n>\3\2\2\2\f@\3\2\2\2\16X\3\2\2\2\20m\3\2\2\2\22\u0086"+
		"\3\2\2\2\24\26\5\4\3\2\25\24\3\2\2\2\25\26\3\2\2\2\26\32\3\2\2\2\27\31"+
		"\5\6\4\2\30\27\3\2\2\2\31\34\3\2\2\2\32\30\3\2\2\2\32\33\3\2\2\2\33!\3"+
		"\2\2\2\34\32\3\2\2\2\35 \5\f\7\2\36 \5\22\n\2\37\35\3\2\2\2\37\36\3\2"+
		"\2\2 #\3\2\2\2!\37\3\2\2\2!\"\3\2\2\2\"$\3\2\2\2#!\3\2\2\2$%\7\2\2\3%"+
		"\3\3\2\2\2&\'\7\20\2\2\'-\7\3\2\2()\7\4\2\2)*\7\5\2\2*+\7\33\2\2+,\7\6"+
		"\2\2,.\7\33\2\2-(\3\2\2\2-.\3\2\2\2.\64\3\2\2\2/\60\7\21\2\2\60\61\7\5"+
		"\2\2\61\62\7\33\2\2\62\63\7\6\2\2\63\65\7\33\2\2\64/\3\2\2\2\64\65\3\2"+
		"\2\2\65\66\3\2\2\2\66\67\7\7\2\2\67\5\3\2\2\289\5\b\5\29:\7\5\2\2:;\5"+
		"\n\6\2;\7\3\2\2\2<=\7\31\2\2=\t\3\2\2\2>?\t\2\2\2?\13\3\2\2\2@A\7\f\2"+
		"\2AV\7\31\2\2BD\7\t\2\2CE\5\4\3\2DC\3\2\2\2DE\3\2\2\2EI\3\2\2\2FH\5\6"+
		"\4\2GF\3\2\2\2HK\3\2\2\2IG\3\2\2\2IJ\3\2\2\2JR\3\2\2\2KI\3\2\2\2LQ\5\20"+
		"\t\2MQ\5\16\b\2NQ\5\22\n\2OQ\5\f\7\2PL\3\2\2\2PM\3\2\2\2PN\3\2\2\2PO\3"+
		"\2\2\2QT\3\2\2\2RP\3\2\2\2RS\3\2\2\2SU\3\2\2\2TR\3\2\2\2UW\7\n\2\2VB\3"+
		"\2\2\2VW\3\2\2\2W\r\3\2\2\2XY\7\16\2\2Yk\7\31\2\2Z\\\7\t\2\2[]\5\4\3\2"+
		"\\[\3\2\2\2\\]\3\2\2\2]a\3\2\2\2^`\5\6\4\2_^\3\2\2\2`c\3\2\2\2a_\3\2\2"+
		"\2ab\3\2\2\2bg\3\2\2\2ca\3\2\2\2df\5\20\t\2ed\3\2\2\2fi\3\2\2\2ge\3\2"+
		"\2\2gh\3\2\2\2hj\3\2\2\2ig\3\2\2\2jl\7\n\2\2kZ\3\2\2\2kl\3\2\2\2l\17\3"+
		"\2\2\2mp\7\r\2\2no\7\31\2\2oq\7\5\2\2pn\3\2\2\2pq\3\2\2\2qr\3\2\2\2r\u0084"+
		"\7\32\2\2su\7\t\2\2tv\5\4\3\2ut\3\2\2\2uv\3\2\2\2vz\3\2\2\2wy\5\6\4\2"+
		"xw\3\2\2\2y|\3\2\2\2zx\3\2\2\2z{\3\2\2\2{\u0080\3\2\2\2|z\3\2\2\2}\177"+
		"\5\20\t\2~}\3\2\2\2\177\u0082\3\2\2\2\u0080~\3\2\2\2\u0080\u0081\3\2\2"+
		"\2\u0081\u0083\3\2\2\2\u0082\u0080\3\2\2\2\u0083\u0085\7\n\2\2\u0084s"+
		"\3\2\2\2\u0084\u0085\3\2\2\2\u0085\21\3\2\2\2\u0086\u0089\7\17\2\2\u0087"+
		"\u0088\7\31\2\2\u0088\u008a\7\5\2\2\u0089\u0087\3\2\2\2\u0089\u008a\3"+
		"\2\2\2\u008a\u008b\3\2\2\2\u008b\u0090\7\31\2\2\u008c\u008d\7\6\2\2\u008d"+
		"\u008f\7\31\2\2\u008e\u008c\3\2\2\2\u008f\u0092\3\2\2\2\u0090\u008e\3"+
		"\2\2\2\u0090\u0091\3\2\2\2\u0091\u0093\3\2\2\2\u0092\u0090\3\2\2\2\u0093"+
		"\u0094\7\13\2\2\u0094\u0099\7\31\2\2\u0095\u0096\7\6\2\2\u0096\u0098\7"+
		"\31\2\2\u0097\u0095\3\2\2\2\u0098\u009b\3\2\2\2\u0099\u0097\3\2\2\2\u0099"+
		"\u009a\3\2\2\2\u009a\u00ad\3\2\2\2\u009b\u0099\3\2\2\2\u009c\u009e\7\t"+
		"\2\2\u009d\u009f\5\4\3\2\u009e\u009d\3\2\2\2\u009e\u009f\3\2\2\2\u009f"+
		"\u00a3\3\2\2\2\u00a0\u00a2\5\6\4\2\u00a1\u00a0\3\2\2\2\u00a2\u00a5\3\2"+
		"\2\2\u00a3\u00a1\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\u00a9\3\2\2\2\u00a5"+
		"\u00a3\3\2\2\2\u00a6\u00a8\5\20\t\2\u00a7\u00a6\3\2\2\2\u00a8\u00ab\3"+
		"\2\2\2\u00a9\u00a7\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa\u00ac\3\2\2\2\u00ab"+
		"\u00a9\3\2\2\2\u00ac\u00ae\7\n\2\2\u00ad\u009c\3\2\2\2\u00ad\u00ae\3\2"+
		"\2\2\u00ae\23\3\2\2\2\35\25\32\37!-\64DIPRV\\agkpuz\u0080\u0084\u0089"+
		"\u0090\u0099\u009e\u00a3\u00a9\u00ad";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}