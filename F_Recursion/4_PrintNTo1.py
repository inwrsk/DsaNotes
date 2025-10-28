'''
if a num sent to func
print the number
print the before number
'''
def prnt(n):
    if n==0:
        return
    print(n,end=' ')
    prnt(n-1)
prnt(10)#10 9 8 7 6 5 4 3 2 1