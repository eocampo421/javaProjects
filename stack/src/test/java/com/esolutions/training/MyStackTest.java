package com.esolutions.training;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.Before;
import org.junit.Test;

import com.esolutions.training.MyStack.NegativeCapacityException;
import com.esolutions.training.MyStack.StackEmptyException;
import com.esolutions.training.MyStack.StackOverFlowException;
import com.esolutions.training.MyStack.StackUnderFlowException;

/**
 * 
 * @author Emanuel_Ocampo
 *
 */
public class MyStackTest {
	private MyStack<Integer> myStack;
	
	@Before
	public void setUp(){
		myStack = new MyStack<Integer>(15);
	}
	
    @Test
    public void a_stack_can_be_created_specifying_a_capacity() {
        assertThat(myStack).isExactlyInstanceOf(MyStack.class);
        assertThat(myStack).isInstanceOf(MyStack.class);
    }

    @Test
    public void a_new_stack_is_empty(){
        assertThat(myStack.isEmpty()).isTrue();
    }

    @Test
    public void the_size_of_a_new_stack_is_0() {
        assertThat(myStack.size()).isEqualTo(0);
    }

    @Test
    public void after_a_push_the_size_of_the_stack_is_1() {
    	int valueToPush = 23;
    	myStack.push(valueToPush);
        assertThat(myStack.size()).isEqualTo(1);
        assertThat(myStack.isEmpty()).isFalse();
    }

    @Test
    public void after_a_push_the_stack_is_not_empty() {
    	myStack.push(25);
        assertThat(myStack.isEmpty()).isFalse();
        assertThat(myStack.size()).isEqualTo(1);
    }

    @Test
    public void after_a_push_and_pop_the_stack_is_empty() {
    	myStack.push(30);
    	myStack.pop();
        assertThat(myStack.isEmpty()).isTrue();
    }

    @Test
    public void after_a_push_and_pop_the_size_of_the_stack_is_0() {
    	int valueToPush = 30;
    	myStack.push(valueToPush);
    	myStack.pop();
    	assertThat(myStack.size()).isEqualTo(0);
    	assertThat(myStack.isEmpty()).isTrue();
    }

    @Test
    public void push_a_value_then_pop_the_value() {
    	int valueToPush = 30;
    	myStack.push(valueToPush);
    	assertThat(myStack.pop()).as("pop").isSameAs(valueToPush);
    }

    @Test
    public void push_A_and_B_then_pop_B_and_A() {
    	int fstValue = 10;
    	int sndValue = 20;
    	myStack.push(fstValue);
    	myStack.push(sndValue);
    	assertThat(myStack.isEmpty()).isFalse();
    	assertThat(myStack.pop()).as("pop").isSameAs(sndValue);
    	assertThat(myStack.pop()).as("pop").isSameAs(fstValue);
    	assertThat(myStack.isEmpty()).isTrue();
    }

    @Test
    public void capacity_of_stack_must_be_non_negative() {
    	assertThatThrownBy(() -> new MyStack<Integer>(-1)).isExactlyInstanceOf(NegativeCapacityException.class)
    	.hasMessageContaining("The capacity has to be >= 0, and is -1.");
    }

    @Test
    public void push_over_capacity_overflows() {
    	MyStack<Integer> myStack = new MyStack<Integer>(0);
    	assertThatThrownBy(() -> myStack.push(1)).isExactlyInstanceOf(StackOverFlowException.class);
    }

    @Test
    public void pop_on_empty_stack_underflows() {
    	assertThatThrownBy(() -> myStack.pop()).isExactlyInstanceOf(StackUnderFlowException.class);
    }

    @Test
    public void pushed_value_is_on_top() {
    	int valueToPush = 50;
    	assertThat(myStack.isEmpty()).isTrue();
    	myStack.push(valueToPush);
        assertThat(myStack.top()).as("top").isSameAs(valueToPush);
        assertThat(myStack.size()).isEqualTo(1);
    }

    @Test
    public void top_on_empty_stack_throws_empty() {
    	MyStack<Integer> myStack = new MyStack<Integer>(0);
    	assertThatThrownBy(() -> myStack.top()).isExactlyInstanceOf(StackEmptyException.class);
    }
}
