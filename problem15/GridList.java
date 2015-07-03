package problem15;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class GridList implements List<GridTile>{

	List<GridTile> grid;
	
	public GridList() {
		grid = new ArrayList<GridTile>();
	}

	@Override
	public Stream<GridTile> parallelStream() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeIf(Predicate<? super GridTile> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Stream<GridTile> stream() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void forEach(Consumer<? super GridTile> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean add(GridTile tile) {
		grid.add(tile);
		return false;
	}

	@Override
	public void add(int index, GridTile tile) {
		grid.add(index, tile);
	}

	@Override
	public boolean addAll(Collection<? extends GridTile> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(int arg0, Collection<? extends GridTile> arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		grid.clear();		
	}

	@Override
	public boolean contains(Object o) {
		if(grid.contains(o) == true)
			return true;
		else
			return false;
	}

	@Override
	public boolean containsAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public GridTile get(int index) {
		return grid.get(index);
	}

	@Override
	public int indexOf(Object o) {
		return grid.indexOf(o);
	}

	@Override
	public boolean isEmpty() {
		if(grid.isEmpty() == true)
			return true;
		else
			return false;
	}

	@Override
	public Iterator<GridTile> iterator() {
		return grid.iterator();
	}

	@Override
	public int lastIndexOf(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ListIterator<GridTile> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator<GridTile> listIterator(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object o) {
		if(grid.remove(o)== true)
			return true;
		else
			return false;
	}

	@Override
	public GridTile remove(int index) {
		return grid.remove(index);
	}

	@Override
	public boolean removeAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void replaceAll(UnaryOperator<GridTile> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean retainAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public GridTile set(int index, GridTile tile) {
		return grid.set(index, tile);
	}

	@Override
	public int size() {
		return grid.size();
	}

	@Override
	public void sort(Comparator<? super GridTile> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Spliterator<GridTile> spliterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GridTile> subList(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public GridTile moveRight(GridTile tile) {
		if(tile.isHorzEdge() == true || grid.get(tile.getID()+1).isVisited()) {
			return null;
		} else
			return grid.get(tile.getID()+1);
	}
	
	public GridTile moveDown(GridTile tile) {
		if(tile.isVertEdge() == true || grid.get(tile.getID()+20).isVisited())
			return null;
		else
			return grid.get(tile.getID()+20);
	}
}
