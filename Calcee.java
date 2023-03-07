package Lab4;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class Calcee extends Applet implements ActionListener{
	int v1,v2,res,i;
	TextField t;
	Button b[]=new Button[10];
	Button add,sub,mul,div,mod,clear,eq;
	char op;
	
	public void init(){
		t=new TextField(50);
		GridLayout g=new GridLayout(4,5);
		setLayout(g);
		for(i=0;i<10;i++){
			b[i]=new Button(""+i);
		}
		add=new Button("+");
		sub=new Button("-");
		mul=new Button("*");
		div=new Button("/");
		mod=new Button("%");
		eq=new Button("=");
		clear=new Button("clear");
		add(t);t.addActionListener(this);
		for(i=0;i<10;i++){
			add(b[i]);
		}
		add(add);add(sub);add(mul);add(div);add(mod);add(eq);add(clear);
		for(i=0;i<10;i++){
			b[i].addActionListener(this);
		}
		add.addActionListener(this);sub.addActionListener(this);mul.addActionListener(this);
		div.addActionListener(this);mod.addActionListener(this);eq.addActionListener(this);
		clear.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ae){
		String str=ae.getActionCommand();
		char ch=str.charAt(0);
		if(Character.isDigit(ch))
			t.setText(t.getText()+str);
		if(str.equals("+")){
			v1=Integer.parseInt(t.getText());
			op='+';
			t.setText("");
		}else if(str.equals("-")){
			v1=Integer.parseInt(t.getText());
			op='-';
			t.setText("");
		}else if(str.equals("*")){
			v1=Integer.parseInt(t.getText());
			op='*';
			t.setText("");
		}else if(str.equals("/")){
			v1=Integer.parseInt(t.getText());
			op='/';
			t.setText("");
		}else if(str.equals("%")){
			v1=Integer.parseInt(t.getText());
			op='%';
			t.setText("");
		}
		
		if(str.equals("=")){
			v2=Integer.parseInt(t.getText());
			if(op=='+')
				res=v1+v2;
			else if(op=='-')
				res=v1-v2;
			else if(op=='*')
				res=v1*v2;
			else if(op=='/')
				res=v1/v2;
			else if(op=='%')
				res=v1%v2;
			t.setText(""+res);
		}
		
		if(str.equals("clear"))
			t.setText("");
	}
}
