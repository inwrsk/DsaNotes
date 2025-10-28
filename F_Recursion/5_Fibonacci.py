'''
fibnocci of a number is the sum  of the previous two numbers and usually starts with 1 1

when num enters
if the num is one of the starting two numbers:
      simply return 1
nope num is not the starting two numbers
then?
ask the function to give fib of prev and fib of prev-1 add them 
'''
def fibnocci(n):
    if n==1 or n==2:
        return 1
    return fibnocci(n-1)+fibnocci(n-2)
print(fibnocci(5))#5
#1 1 2 3 5