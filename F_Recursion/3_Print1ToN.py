'''
if a num sent to func:
if it is 1 then print the number
else print the before number
'''
def prnt(n):
    if n==0:
        return
    prnt(n-1)
    print(n,end=' ')
prnt(10)#1 2 3 4 5 6 7 8 9 10

print('\nsecond func')

def prnt2(n):
    if n==1:
        print(1)
        return
    prnt(n-1)
    print(n)
prnt2(10)#1 2 3 4 5 6 7 8 9 10