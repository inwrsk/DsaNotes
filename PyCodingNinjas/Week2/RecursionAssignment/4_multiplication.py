a=7
b=5
def multiplication(m,n):
    if n==0:
        return 0
    else:
        return m+multiplication(m,n-1)
print(multiplication(a,b))#35