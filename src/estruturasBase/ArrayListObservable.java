/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package estruturasBase;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author rb
 */
public class ArrayListObservable<E> extends ArrayList<E>{

    /**
     *
     */
    public static final String ADD_ITEM = "ADD_ITEM";
    public static final String REMOVE_ITEM = "REMOVE_ITEM";
    public static final String CLEAR_ITEM = "CLEAR_ITEM";
    public static final String CHANGE_ITEM = "CHANGE_ITEM";
    
    private final PropertyChangeSupport propertySupport;

    public ArrayListObservable(int initialCapacity) {
        super(initialCapacity);
        this.propertySupport = new PropertyChangeSupport(this);  
    }

    public ArrayListObservable() {
        this.propertySupport = new PropertyChangeSupport(this);
    }

    public ArrayListObservable(Collection<? extends E> c) {
        super(c);
        this.propertySupport = new PropertyChangeSupport(this);
    }

    
    @Override
    public boolean add(E o){
        boolean test = super.add(o);
        propertySupport.firePropertyChange(ADD_ITEM, null, o);
        
        return test;
    }
    
    @Override
    public void add(int i, E o){
        super.add(i, o);
        propertySupport.firePropertyChange(ADD_ITEM, null, o);

    }

    @Override
    public void clear(){
        super.clear();
        propertySupport.firePropertyChange(CLEAR_ITEM, null, null);
    }
    
    @Override
    public boolean remove(Object o){
        boolean test = super.remove(o);
        propertySupport.firePropertyChange(REMOVE_ITEM, o, null);
        
        return test;
    }
    
    @Override
    public E remove(int i){
        E test = super.remove(i);
        propertySupport.firePropertyChange(REMOVE_ITEM, test, null);
        
        return test;
    }
    
    @Override
    public E set(int i, E o){
        propertySupport.firePropertyChange(CHANGE_ITEM, super.set(i, o), o);
        E test = super.set(i, o);
        
        return test;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.removePropertyChangeListener(listener);
    }

    public void addPropertyChangeListener(String propertyName, PropertyChangeListener listener) {
        propertySupport.addPropertyChangeListener(propertyName, listener);
    }

    public void removePropertyChangeListener(String propertyName, PropertyChangeListener listener) {
        propertySupport.removePropertyChangeListener(propertyName, listener);
    } 
}
