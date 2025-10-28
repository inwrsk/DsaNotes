#method 1:using new array every time takes more space
def func(arr,num,lengthofarray):
    if arr[0]==num:
        return 0
    if len(arr)==1:
        return -lengthofarray
    return 1+func(arr[1:],num,lengthofarray)
print(func([1,2,3,4,5],3,5))#2
print(func([1,2,3,4,5],7,5))#-1
#method2:using the same array to reduce space
def func2(arr,si,num):
    if num==arr[si]:
        return si
    if si==len(arr)-1:
        return -1
    return func2(arr,si+1,num)
print(func2([1,2,3,4,5],0,3))#2
print(func2([1,2,3,4,5],0,7))#-1
#method3:with out using lenofarr as argument in first method
def func3(arr,num):
    size=len(arr)
    if size==0:return -1
    if arr[0]==num:return 0
    smallindex=func3(arr[1:],num)
    if smallindex==-1:return -1
    return smallindex+1
print(func3([1,2,3,4,5],3))#2
print(func3([1,2,3,4,5],7))#-1