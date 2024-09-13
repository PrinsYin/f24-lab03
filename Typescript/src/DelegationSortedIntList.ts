import { SortedIntList } from './hidden/SortedIntListLibrary.js'
import { IntegerList } from './IntegerList.js';

/**
 * DelegationSortedIntList -- a variant of a SortedIntList that keeps
 * count of the number of attempted element insertions (not to be confused
 * with the current size, which goes down when an element is removed)
 * and exports an accessor (totalAdded) for this count.
 *
 * @author Nora Shoemaker
 *
 */

class DelegationSortedIntList implements IntegerList{
  private sortedList: SortedIntList;
  private totalAdded: number;

  constructor() {
    this.sortedList = new SortedIntList();
    this.totalAdded = 0; 
  }


  add(value: number): boolean {
    this.totalAdded++; 
    return this.sortedList.add(value); 
  }

  addAll(values: IntegerList): boolean {
    this.totalAdded += values.size(); 
    return this.sortedList.addAll(values); 
  }


  getTotalAdded(): number {
    return this.totalAdded;
  }


  remove(value: number): boolean {
    return this.sortedList.remove(value);
  }


  get(index: number): number {
    return this.sortedList.get(index);
  }

  size(): number {
    return this.sortedList.size();
  }

  removeAll (list: IntegerList): boolean {
    let success = true

    for (let i = 0; i < list.size(); ++i) {
      success &&= this.remove(list.get(i))
    }
    return success
  }
}


export { DelegationSortedIntList }
