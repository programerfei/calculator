package com.zpf.ui;

import java.awt.TextField;
import java.math.BigDecimal;
import java.util.Stack;

public class Calculate {
	private String str_textField=null;//获取GUI文本框的字符串
	/**
	 * 进行整数计算所用的栈
	 */
	private Stack<Character> stack_char;//创建栈用来存储运算字符
	private Stack<Double> stack_int;//创建栈用来存储运算数字
	/**
	 * 进行浮点数计算所用的栈
	 * @param c
	 */
	private Stack<Character> stack_char2=null;//创建栈用来存储运算字符
	private Stack<Double> stack_double=null;//创建栈用来存储运算浮点数数字
	
	//将计算的字符串的值传入到该类的成员变量中
	public void setStr(Caltulator_UI c) {
		str_textField=c.getTextField();
	}
	
	//获取文本框中的字符串
	public String getStr() {
		return str_textField;
	}
	
	//判断从字符串中取出的字符是否是数字  如果是则返回true 否则返回false
	public boolean isNumber(char c) {
		if(c>='0'&&c<='9') {
			return true;
		}else {
			return false;
		}
	}
	
	
	//判断括号和运算符的优先级
	/**
	 * 第1级: (
	 第2级: * /
	 第3级: + -
	 第4级: )
	 * @param symbol
	 * @return
	 */
	
	/**
	 *如果栈为空，则无论是数字字符还是符号字符一律入栈
	 */
	public boolean comparePri(char symbol,boolean b) {
		//若参数b为true，则进行浮点数计算
		if(b==true) {
			if(stack_char2.empty()) {//如果符号栈为空,返回true，即能直接入栈
				return true;
			}else {//若符号栈不为空
				char top=(char)stack_char2.peek();//查看栈顶元素，将栈顶元素和当前字符进行比较并判断是进行运算还是入栈
				if(top=='(') {//如果栈顶元素为左括号，则返回false
					return false;
				}
				//进行优先级的比较
				switch(symbol) {
				case'(':
					return false;
				case'*':{
					if (top == '+' || top == '-') // 优先级比+和-高
						return false;
					else
						return true;
				}
				case'/':{
					if (top == '+' || top == '-') // 优先级比+和-高
						return false;
					else
						return true;
				}
				case'+':
					return false;//优先级最低
				case'-':
					return false;//优先级最低
				case ')': // 优先级最高
					return true;
				case '=': // 优先级最高
					return true;
				default:
					break;
				}
			}
		}
		
		if(b==false) {
			//若参数b为整数，则进行整数计算
			if(stack_char.empty()) {//如果符号栈为空,返回true，即能直接入栈
				return true;
			}else {//若栈不为空
				char top=(char)stack_char.peek();//查看栈顶元素，将栈顶元素和当前字符进行比较并判断是进行运算还是入栈
				if(top=='(') {
					return false;
				}
				//进行优先级的比较
				switch(symbol) {
				case'(':
					return false;
				case'*':{
					if (top == '+' || top == '-') // 优先级比+和-高
						return false;
					else
						return true;
				}
				case'/':{
					if (top == '+' || top == '-') // 优先级比+和-高
						return false;
					else
						return true;
				}
				case'+':
					return false;//优先级最低
				case'-':
					return false;//优先级最低
				case ')': // 优先级最高
					return true;
				case '=': // 优先级最高
					return true;
				default:
					break;
				}
			}
		}
		return true;
	}
		
	
	//添加方法判断字符串是整数字符串还是浮点数字符串
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
	
	//判断算式中是否有负号的方法,若返回true，则此括号中包含的便是负数
	public boolean isFuhao(int i,String ss) {
		boolean bool=false;
		//左括号后面直接跟负号
		if(ss.charAt(i)=='('&&ss.charAt(i+1)=='-') {
			bool=true;
		}else {
			bool=false;
		}
		return bool;
	}
	
	
	public String calcluate(String s) {
		String ss=null;//返回的字符串
		//开始时进行字符串判断，即浮点数字符串和整数字符串判断,false为整数，true为浮点数
		/**
		 * 将最终的返回类型设置为字符串类型，
		 */
		boolean bool;
		bool=compare(s);//调用字符串判断方法判断是整数字符串还是浮点数字符串
		
		//整数计算
		if(bool==false) {
			//初始化栈
			stack_char=new Stack();//字符栈实例化
			stack_int=new Stack();//数字栈实例化
			//设置字符缓冲 用于缓存数字，因为数字可能是多位的
			StringBuffer temp = new StringBuffer();
			
			//从获取的表达式的第一个字符串进行处理操作
			for(int i=0;i<s.length();i++) {
				boolean flag;
				flag=isFuhao(i,s);
				
				//若flag为true则表明此符号和下一个符号便是( -
				if(flag==true) {
					String string1=s.substring(i);
					int fristNum=string1.indexOf(")");
					String string2=string1.substring(1, fristNum);
					
					double number=Double.parseDouble(string2);
					stack_int.push(number);//将负数入栈
					i=i+fristNum;
				}
				//若flag为false，则表明当前字符和下一字符不是  ( -
				if(flag==false) {
					char ch1=s.charAt(i);//获取一个字符
					if(isNumber(ch1)) {//如果该字符是数字
						temp.append(ch1);//将数字添加到缓冲中
					}else {//如果不是数字
						String string=temp.toString();//将数字缓冲转换成字符串  例如12
						if (!string.isEmpty()) {
							 double num = Double.parseDouble(string); // 将数字字符串转为长整型数  12
							 stack_int.push(num); // 将数字压栈
							 temp = new StringBuffer(); // 重置数字缓存
						}
						// 判断运算符的优先级，若当前优先级低于栈顶的优先级，则先把计算前面计算出来
						// && !stack_char.empty()
						while (comparePri(ch1,bool)!=false && stack_char.empty()!=true) {
							double b=stack_int.pop();
							double a=stack_int.pop();//出栈
							//将取出的数字进行运算，并且将当前运算的计算结果在此压入栈中
							//查看符号栈顶符号
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
						}//while循环结束 
						if(ch1!='=') {
							stack_char.push(new Character(ch1));//符号入栈
							if(ch1==')') {//进行去括号操作
								stack_char.pop();
								stack_char.pop();
							}
						}
						
					}//else
				}//for循环
				}
				
			double ab=stack_int.pop();
			ss=String.valueOf(ab);
		}//if语句结束
		
        //浮点数计算
		if(bool==true) {
			//实例化栈
			stack_char2=new Stack();
			stack_double=new Stack();
			//设置字符缓冲 用于缓存数字，因为数字可能是多位的
			StringBuffer temp2 = new StringBuffer();
			for(int i=0;i<s.length();i++) {
				
				boolean flag;
				flag=isFuhao(i,s);
				
				if(flag==true) {
					String string1=s.substring(i);
					int fristNum=string1.indexOf(")");
					String string2=string1.substring(1, fristNum);
					
					double number=Double.parseDouble(string2);
					stack_int.push(number);//将负数入栈
					i=i+fristNum;
				}
				if(flag==false) {
					char ch2=s.charAt(i);//获取第一个字符
					if(isNumber(ch2)) {
						
						temp2.append(ch2);
					}else if(ch2=='.') {
						temp2.append(ch2);
					}
					else {//如果不是数字并且不是小数点
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
						}//while循环结束
						if(ch2!='=') {
							stack_char2.push(new Character(ch2));//符号入栈
							if(ch2==')') {//进行去括号操作
								stack_char2.pop();
								stack_char2.pop();
							}
						}
					}
				}
				
			}//for循环结束
			double ab=stack_double.pop();
			ss=String.valueOf(ab);
			
		}
		return ss;
		
    }
	
}
