def maxDepth(n):
    if n==0:
        return 0
    return n+maxDepth(n-1)
print(maxDepth(997))#497503
#by default python has 1000 as maxRecursion depth(in my system)