'''
take the array and the inital position
check whether the array we should check reached last position
if yes it is true that containing 1 element is sorted
No: it has more than 1 element to check
compare the first two elemtns if not in order it is not sorted
yes they are in order : check for the rest of array leaving the number just we checked
'''
def checkSorted(arr,si):
    print(id(arr))
    if  si==len(arr)-1:
        return True
    if arr[si]<arr[si+1]:
        return checkSorted(arr,si+1)
    return False
print(checkSorted([1,2,3,4,5],0))#True
'''
2776461735616
2776461735616
2776461735616
2776461735616
2776461735616
'''
#same array is used so no more additional space is used like before 