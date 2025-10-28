'''
first sort the two haves of the array and combine them
'''
def merge(arr1,arr2,arr):
    i=0
    j=0
    k=0
    while(i<len(arr1) and j<len(arr2)):
        if arr1[i]<arr2[j]:
            arr[k]=arr1[i]
            i+=1
            k+=1
        else:
            arr[k]=arr2[j]
            j+=1
            k+=1
    if i<len(arr1):
        arr[k:]=arr1[i:]
        return
    arr[k:]=arr2[j:]

def mergeSort(arr):
    if len(arr)>1:
        l=len(arr)
        arr1=arr[:l//2]
        arr2=arr[l//2:]
        mergeSort(arr1)
        mergeSort(arr2)
        merge(arr1,arr2,arr)
    
arr=[2,1,4,1,5,2,2,6,83,2]
mergeSort(arr)
print(arr)#[1, 1, 2, 2, 2, 2, 4, 5, 6, 83]