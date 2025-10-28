'''
A child is running up a staircase with N steps, and can hop either 1 step, 2 steps 
or 3 steps at a time. Implement a method to count how many possible ways the child 
can run up to the stairs. You need to return number of possible ways W.
'''
def stairCase(n):
    if n<1:
        return 0
    if n<4:
        return 1+stairCase(n-1)+stairCase(n-2)+stairCase(n-3)
    return stairCase(n-1)+stairCase(n-2)+stairCase(n-3)
print(stairCase(1))#1
print(stairCase(2))#2
print(stairCase(3))#4
print(stairCase(4))#7
print(stairCase(5))#13