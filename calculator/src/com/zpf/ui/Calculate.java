package com.zpf.ui;

import java.awt.TextField;
import java.math.BigDecimal;
import java.util.Stack;

public class Calculate {
	private String str_textField=null;//��ȡGUI�ı�����ַ���
	/**
	 * ���������������õ�ջ
	 */
	private Stack<Character> stack_char;//����ջ�����洢�����ַ�
	private Stack<Double> stack_int;//����ջ�����洢��������
	/**
	 * ���и������������õ�ջ
	 * @param c
	 */
	private Stack<Character> stack_char2=null;//����ջ�����洢�����ַ�
	private Stack<Double> stack_double=null;//����ջ�����洢���㸡��������
	
	//��������ַ�����ֵ���뵽����ĳ�Ա������
	public void setStr(Caltulator_UI c) {
		str_textField=c.getTextField();
	}
	
	//��ȡ�ı����е��ַ���
	public String getStr() {
		return str_textField;
	}
	
	//�жϴ��ַ�����ȡ�����ַ��Ƿ�������  ������򷵻�true ���򷵻�false
	public boolean isNumber(char c) {
		if(c>='0'&&c<='9') {
			return true;
		}else {
			return false;
		}
	}
	
	
	//�ж����ź�����������ȼ�
	/**
	 * ��1��: (
	 ��2��: * /
	 ��3��: + -
	 ��4��: )
	 * @param symbol
	 * @return
	 */
	
	/**
	 *���ջΪ�գ��������������ַ����Ƿ����ַ�һ����ջ
	 */
	public boolean comparePri(char symbol,boolean b) {
		//������bΪtrue������и���������
		if(b==true) {
			if(stack_char2.empty()) {//�������ջΪ��,����true������ֱ����ջ
				return true;
			}else {//������ջ��Ϊ��
				char top=(char)stack_char2.peek();//�鿴ջ��Ԫ�أ���ջ��Ԫ�غ͵�ǰ�ַ����бȽϲ��ж��ǽ������㻹����ջ
				if(top=='(') {//���ջ��Ԫ��Ϊ�����ţ��򷵻�false
					return false;
				}
				//�������ȼ��ıȽ�
				switch(symbol) {
				case'(':
					return false;
				case'*':{
					if (top == '+' || top == '-') // ���ȼ���+��-��
						return false;
					else
						return true;
				}
				case'/':{
					if (top == '+' || top == '-') // ���ȼ���+��-��
						return false;
					else
						return true;
				}
				case'+':
					return false;//���ȼ����
				case'-':
					return false;//���ȼ����
				case ')': // ���ȼ����
					return true;
				case '=': // ���ȼ����
					return true;
				default:
					break;
				}
			}
		}
		
		if(b==false) {
			//������bΪ�������������������
			if(stack_char.empty()) {//�������ջΪ��,����true������ֱ����ջ
				return true;
			}else {//��ջ��Ϊ��
				char top=(char)stack_char.peek();//�鿴ջ��Ԫ�أ���ջ��Ԫ�غ͵�ǰ�ַ����бȽϲ��ж��ǽ������㻹����ջ
				if(top=='(') {
					return false;
				}
				//�������ȼ��ıȽ�
				switch(symbol) {
				case'(':
					return false;
				case'*':{
					if (top == '+' || top == '-') // ���ȼ���+��-��
						return false;
					else
						return true;
				}
				case'/':{
					if (top == '+' || top == '-') // ���ȼ���+��-��
						return false;
					else
						return true;
				}
				case'+':
					return false;//���ȼ����
				case'-':
					return false;//���ȼ����
				case ')': // ���ȼ����
					return true;
				case '=': // ���ȼ����
					return true;
				default:
					break;
				}
			}
		}
		return true;
	}
		
	
	//��ӷ����ж��ַ����������ַ������Ǹ������ַ���
	public boolean compare(String ss) {
		boolean bool = false;
		for(int i=0;i<ss.length();i++) {
			
			if(ss.charAt(i)=='.') {
				bool= true;
				break;
			}else {
				bool= false;
			}
		}
		return bool;
	}
	
	//�ж���ʽ���Ƿ��и��ŵķ���,������true����������а����ı��Ǹ���
	public boolean isFuhao(int i,String ss) {
		boolean bool=false;
		//�����ź���ֱ�Ӹ�����
		if(ss.charAt(i)=='('&&ss.charAt(i+1)=='-') {
			bool=true;
		}else {
			bool=false;
		}
		return bool;
	}
	
	
	public String calcluate(String s) {
		String ss=null;//���ص��ַ���
		//��ʼʱ�����ַ����жϣ����������ַ����������ַ����ж�,falseΪ������trueΪ������
		/**
		 * �����յķ�����������Ϊ�ַ������ͣ�
		 */
		boolean bool;
		bool=compare(s);//�����ַ����жϷ����ж��������ַ������Ǹ������ַ���
		
		//��������
		if(bool==false) {
			//��ʼ��ջ
			stack_char=new Stack();//�ַ�ջʵ����
			stack_int=new Stack();//����ջʵ����
			//�����ַ����� ���ڻ������֣���Ϊ���ֿ����Ƕ�λ��
			StringBuffer temp = new StringBuffer();
			
			//�ӻ�ȡ�ı��ʽ�ĵ�һ���ַ������д������
			for(int i=0;i<s.length();i++) {
				boolean flag;
				flag=isFuhao(i,s);
				
				//��flagΪtrue������˷��ź���һ�����ű���( -
				if(flag==true) {
					String string1=s.substring(i);
					int fristNum=string1.indexOf(")");
					String string2=string1.substring(1, fristNum);
					
					double number=Double.parseDouble(string2);
					stack_int.push(number);//��������ջ
					i=i+fristNum;
				}
				//��flagΪfalse���������ǰ�ַ�����һ�ַ�����  ( -
				if(flag==false) {
					char ch1=s.charAt(i);//��ȡһ���ַ�
					if(isNumber(ch1)) {//������ַ�������
						temp.append(ch1);//��������ӵ�������
					}else {//�����������
						String string=temp.toString();//�����ֻ���ת�����ַ���  ����12
						if (!string.isEmpty()) {
							 double num = Double.parseDouble(string); // �������ַ���תΪ��������  12
							 stack_int.push(num); // ������ѹջ
							 temp = new StringBuffer(); // �������ֻ���
						}
						// �ж�����������ȼ�������ǰ���ȼ�����ջ�������ȼ������ȰѼ���ǰ��������
						// && !stack_char.empty()
						while (comparePri(ch1,bool)!=false && stack_char.empty()!=true) {
							double b=stack_int.pop();
							double a=stack_int.pop();//��ջ
							//��ȡ�������ֽ������㣬���ҽ���ǰ����ļ������ڴ�ѹ��ջ��
							//�鿴����ջ������
							char z=stack_char.pop();
							switch(z) {
							case'+':
								stack_int.push(a+b);
								break;
							case'-':
								stack_int.push(a-b);
								break;
							case'*':
								stack_int.push(a*b);
								break;
							case'/':
								stack_int.push(a/b);
								break;
							default:
									break;
							}
						}//whileѭ������ 
						if(ch1!='=') {
							stack_char.push(new Character(ch1));//������ջ
							if(ch1==')') {//����ȥ���Ų���
								stack_char.pop();
								stack_char.pop();
							}
						}
						
					}//else
				}//forѭ��
				}
				
			double ab=stack_int.pop();
			ss=String.valueOf(ab);
		}//if������
		
        //����������
		if(bool==true) {
			//ʵ����ջ
			stack_char2=new Stack();
			stack_double=new Stack();
			//�����ַ����� ���ڻ������֣���Ϊ���ֿ����Ƕ�λ��
			StringBuffer temp2 = new StringBuffer();
			for(int i=0;i<s.length();i++) {
				
				boolean flag;
				flag=isFuhao(i,s);
				
				if(flag==true) {
					String string1=s.substring(i);
					int fristNum=string1.indexOf(")");
					String string2=string1.substring(1, fristNum);
					
					double number=Double.parseDouble(string2);
					stack_int.push(number);//��������ջ
					i=i+fristNum;
				}
				if(flag==false) {
					char ch2=s.charAt(i);//��ȡ��һ���ַ�
					if(isNumber(ch2)) {
						
						temp2.append(ch2);
					}else if(ch2=='.') {
						temp2.append(ch2);
					}
					else {//����������ֲ��Ҳ���С����
						String string=temp2.toString();
						if(!string.isEmpty()) {
							double num=Double.parseDouble(string);
							stack_double.push(num);
							temp2=new StringBuffer();
						}
						
						while(comparePri(ch2,bool)!=false && stack_char2.empty()!=true) {
							double b=stack_double.pop();
							double a=stack_double.pop();
							
							char z2=stack_char2.pop();
							switch(z2) {
							case'+':
								stack_double.push(a+b);
								break;
							case'-':
								stack_double.push(a-b);
								break;
							case'*':
								stack_double.push(a*b);
								break;
							case'/':
								stack_double.push(a/b);
								break;
							default:
									break;
							}
						}//whileѭ������
						if(ch2!='=') {
							stack_char2.push(new Character(ch2));//������ջ
							if(ch2==')') {//����ȥ���Ų���
								stack_char2.pop();
								stack_char2.pop();
							}
						}
					}
				}
				
			}//forѭ������
			double ab=stack_double.pop();
			ss=String.valueOf(ab);
			
		}
		return ss;
		
    }
	
}
