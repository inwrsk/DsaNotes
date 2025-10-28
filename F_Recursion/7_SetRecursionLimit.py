import sys
sys.setrecursionlimit(1500)
def maxDepth(n):
    if n==0:
        return 0
    return n+maxDepth(n-1)
print(maxDepth(1497))#1121253
'''
print=1
maxDepth(0)-1 implies maxDepth(1497)=1498
may be the program it self =1
so in total 1+1498+1=1500
'''
