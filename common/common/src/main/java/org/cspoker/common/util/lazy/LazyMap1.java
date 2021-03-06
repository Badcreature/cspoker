/**
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program; if not, write to the Free Software
 *  Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA 02111-1307, USA.
 */
package org.cspoker.common.util.lazy;

import java.util.concurrent.ConcurrentHashMap;


public class LazyMap1<K,V,E extends Throwable> {

	private static final long serialVersionUID = -7366678021380297939L;

	private final ConcurrentHashMap<K, IWrapper1<V,E>> wrappedMap = new ConcurrentHashMap<K, IWrapper1<V,E>>();
	
	public V getOrCreate(K key, final IFactory1<? extends V,? extends E> factory) throws E {
		IWrapper1<V, E> wrapper = wrappedMap.get(key);
		if(wrapper!=null){
			return wrapper.getContent();
		}
		wrappedMap.putIfAbsent(key, new IWrapper1<V,E>(){

			private V content = null;
			
			public synchronized V getContent() throws E {
				if(content == null){
					content = factory.create();
				}
				return content;
			}
			
		});
		return wrappedMap.get(key).getContent();
	}

	public void remove(Object key) {
		wrappedMap.remove(key);
	}

}
