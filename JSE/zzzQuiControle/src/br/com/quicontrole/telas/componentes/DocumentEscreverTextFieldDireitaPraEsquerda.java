package br.com.quicontrole.telas.componentes;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class DocumentEscreverTextFieldDireitaPraEsquerda extends PlainDocument {	
	private static final long serialVersionUID = -4609813818752720573L;
	
	//add ao campo de texto
	//campoDeTexto.setDocument(new DocumentEscreverTextFieldDireitaPraEsquerda());
	

	public void insertString(int offs, String str, AttributeSet a)
            throws BadLocationException
    {
        String texto = getText(0, getLength());
        if(texto.length() < 10) {
            remove(0, getLength());
            StringBuffer strBuf = new StringBuffer(texto.replaceAll(",", "") + str);
            if(strBuf.length() < 3) strBuf.insert(0, ",");
            else strBuf.insert(strBuf.length() - 2, ",");
            super.insertString(0, strBuf.toString(), a);
        }
    }
}
