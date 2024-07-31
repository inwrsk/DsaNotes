#sum of digits in a integer
def func(n):
    if n==n%10:
        return n
    else:
        return n%10+func(n//10)
print(func(2301))#6