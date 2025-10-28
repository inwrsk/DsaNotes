#binary search works on sorted arrays0
'''
it takes sorted array 
if mid element less than key 
yes?check in array greater than mid element
NO it is greater?check below mid
equal? retur the index of mid
'''
def binsearch(arr,key,li,hi):
    if li>hi:
        return -1
    mid=(li+hi)//2
    if arr[mid]==key:
        return mid
    elif arr[mid]>key:
        return binsearch(arr,key,li,mid-1)
    return binsearch(arr,key,mid+1,hi)
print(binsearch([1,3,5,7,8],3,0,4))#1