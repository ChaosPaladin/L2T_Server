/*
 * $Header: L2ObjectSet.java, 22/07/2005 13:22:46 luisantonioa Exp $
 *
 * $Author: luisantonioa $
 * $Date: 22/07/2005 13:22:46 $
 * $Revision: 1 $
 * $Log: L2ObjectSet.java,v $
 * Revision 1  22/07/2005 13:22:46  luisantonioa
 * Added copyright notice
 *
 *
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License along with
 * this program. If not, see <http://www.gnu.org/licenses/>.
 */

package l2server.util;

import l2server.Config;
import l2server.gameserver.model.L2Object;
import l2server.gameserver.model.actor.L2Playable;

import java.util.Iterator;

/**
 * This class ...
 *
 * @version $Revision: 1.2 $ $Date: 2004/06/27 08:12:59 $
 */

public abstract class L2ObjectSet<T extends L2Object> implements Iterable<T>
{
	public static L2ObjectSet<L2Object> createL2ObjectSet()
	{
		switch (Config.SET_TYPE)
		{
			case WorldObjectSet:
				return new WorldObjectSet<>();
			default:
				return new L2ObjectHashSet<>();
		}
	}

	public static L2ObjectSet<L2Playable> createL2PlayerSet()
	{
		switch (Config.SET_TYPE)
		{
			case WorldObjectSet:
				return new WorldObjectSet<>();
			default:
				return new L2ObjectHashSet<>();
		}
	}

	public abstract int size();

	public abstract boolean isEmpty();

	public abstract void clear();

	public abstract void put(T obj);

	public abstract void remove(T obj);

	public abstract boolean contains(T obj);

	@Override
	public abstract Iterator<T> iterator();
}
