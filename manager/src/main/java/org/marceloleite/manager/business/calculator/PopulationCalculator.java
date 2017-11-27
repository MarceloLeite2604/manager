package org.marceloleite.manager.business.calculator;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.marceloleite.management.lot.Lot;
import org.marceloleite.management.lot.LotType;
import org.marceloleite.management.map.Slot;
import org.marceloleite.management.map.Slots;

public class PopulationCalculator implements Calculator {

	private Slots slots;

	public PopulationCalculator(Slots slots) {
		super();
		this.slots = slots;
	}

	@Override
	public double calculate() {
		double population = 0;
		Map<Long, Slot> slotsMap = slots.getSlotsMap();
		Set<Long> slotIds = slotsMap.keySet();

		Set<Entry<Long, Slot>> entrySet = slotsMap.entrySet();

		Iterator<Entry<Long, Slot>> iterator = entrySet.iterator();
		Entry<Long, Slot> next = iterator.next();
		next.getKey();
		next.getValue();

		for (Long slotId : slotIds) {
			Slot slot = slotsMap.get(slotId);
			if (slot.isOccupied()) {
				Lot lot = slot.getLot();
				if (lot.isOccupied() && lot.getLotType() == LotType.RESIDENTIAL) {
					population += lot.getBuilding().getInhabitants().getSize();
				}
			}
		}

		return population;
	}
}
