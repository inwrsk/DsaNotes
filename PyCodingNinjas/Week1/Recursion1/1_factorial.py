'''
when n is passed to function
if it is 0 : nothing to do much with simply return 1
else
it returns n* factorial of previous number
'''
def factorial(n):
    if n==0:
        return 1
    return n*factorial(n-1)
print(factorial(5))#120