'''
first take one element i.e pivot
place the pivot such that left elements are smaller and right ones are bigger or equal
then again same procedure for left and right
'''
#it is faster than mergesort
def placePivot(a,l,r):
    elem=a[l]
    ind=l
    for i in range(l+1,r+1):
        if elem>a[i]:
            ind+=1
            a.insert(l,a[i])
            del a[i+1]
    return ind

def quickSort(arr,l,r):
    if l<r:
        ind=placePivot(arr,l,r)
        quickSort(arr,l,ind)
        quickSort(arr,ind+1,len(arr)-1)

arr=[3,2,14,2,5,  1,6]
quickSort(arr,0,len(arr)-1)
print(arr)#[1, 2, 2, 3, 5, 6, 14]