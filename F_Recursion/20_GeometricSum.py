'''
Given k, find the geometric sum i.e.
1 + 1/2 + 1/4 + 1/8 + ... + 1/(2^k) 
'''
n=3
def geometricSum(n):
    if n==0:
        return 1
    else :
        return (1/2**n)+geometricSum(n-1)
res=f"{geometricSum(n):.5f}"
print(res)#1.87500