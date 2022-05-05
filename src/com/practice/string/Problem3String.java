package com.practice.string;

import java.util.Stack;

public class Problem3String {
	
	public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++) {
        	if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[')
        		stack.push(s.charAt(i));
        	else {
        		switch(s.charAt(i)) {
        		case ')':{
        			if(stack.isEmpty())
        				return false;
        			char c = stack.pop();
        			if(c!='(')
        				return false;
        			break;
        		}
        		case '}':{
        			if(stack.isEmpty())
        				return false;
        			char c = stack.pop();
        			if(c!='{')
        				return false;
        			break;
        		}
        		case ']':{
        			if(stack.isEmpty())
        				return false;
        			char c = stack.pop();
        			if(c!='[')
        				return false;
        			break;
        		}
        		       
        		}
        	}
        }
        if(!stack.isEmpty())
        	return false;
        return true;
    }

	public static void main(String[] args) {
		
	}

}
