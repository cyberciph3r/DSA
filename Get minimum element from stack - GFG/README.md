# Get minimum element from stack
## Medium
<div class="problems_problem_content__Xm_eO"><p><span style="font-size:18px">You are given <strong>N</strong>&nbsp;elements&nbsp;and your task is to Implement a Stack in which you can get minimum element in O(1) time.</span></p>

<p><span style="font-size:18px"><strong>Example 1:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input:
</strong>push(2)
push(3)
pop()
getMin()
push(1)
getMin()<strong>
Output: </strong>3 2 1<strong>
Explanation: </strong>In the first test case for
query&nbsp;
push(2)&nbsp; Insert 2 into the stack.
&nbsp;        The stack&nbsp;will be {2}
push(3)&nbsp; Insert 3 into the stack.
&nbsp;        The stack&nbsp;will be {2 3}
pop()    Remove top element from stack 
&nbsp;        Poped element will be 3&nbsp;the
&nbsp;        stack will be {2}
getMin() Return the minimum element
&nbsp;        min element will be 2&nbsp;
push(1)  Insert 1 into the stack.
         The stack&nbsp;will be {2 1}
getMin() Return the minimum element
&nbsp;        min element will be 1</span>
</pre>

<p><span style="font-size:18px"><strong>Your Task:</strong><br>
You are required to complete the three&nbsp;methods&nbsp;<strong>push()</strong>&nbsp;which take one argument an integer <strong>'x'</strong>&nbsp;to be pushed into the stack,&nbsp;<strong>pop()</strong>&nbsp;which returns a integer&nbsp;poped out from the stack and <strong>getMin()</strong> which returns the min element from the stack. (-1 will be returned if for&nbsp;<strong>pop() and getMin()&nbsp;</strong>the stack is empty.)</span></p>

<p><span style="font-size:18px"><strong>Expected Time Complexity</strong> : O(1) for all the 3 methods.<br>
<strong>Expected Auixilliary Space</strong> : O(1) for all the 3 methods.</span></p>

<p><span style="font-size:18px"><strong>Constraints:</strong><br>
1 &lt;= Number of queries&nbsp;&lt;= 100<br>
1 &lt;= values of the stack&nbsp;&lt;= 100</span></p>
</div>