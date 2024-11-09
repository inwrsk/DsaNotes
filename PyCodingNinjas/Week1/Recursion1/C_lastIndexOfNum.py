'''
array empty return-1 
not empty? find the index of the number in the beside array
if it find the num in beside array: then 1(itself)+index
not found? check whether it has ? yes? return 0(itself) ; no?return -1(not available in the market)
'''
def func(arr,num):
    if len(arr)==0:
        return -1
    ind=func(arr[1:],num)
    if ind==-1:
        if arr[0]==num:
            return 0 
        return -1
    else:
        return 1+ind
print(func([1,2,3,3,4,2,5],2))#5
print(func([1,2,3,3,4,2,5],20))#-1