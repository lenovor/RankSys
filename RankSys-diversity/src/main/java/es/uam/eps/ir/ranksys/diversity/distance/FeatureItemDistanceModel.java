/* 
 * Copyright (C) 2014 Information Retrieval Group at Universidad Autonoma
 * de Madrid, http://ir.ii.uam.es
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package es.uam.eps.ir.ranksys.diversity.distance;

import es.uam.eps.ir.ranksys.core.IdValuePair;
import es.uam.eps.ir.ranksys.core.feature.FeatureData;
import java.util.stream.Stream;

/**
 *
 * @author Saúl Vargas (saul.vargas@uam.es)
 */
public abstract  class FeatureItemDistanceModel<I, F, V> implements ItemDistanceModel<I> {

    private final FeatureData<I, F, V> featureData;

    public FeatureItemDistanceModel(FeatureData<I, F, V> featureData) {
        this.featureData = featureData;
    }

    @Override
    public double dist(I i, I j) {
        return dist(featureData.getItemFeatures(i), featureData.getItemFeatures(j));
    }

    public abstract double dist(Stream<IdValuePair<F, V>> features1, Stream<IdValuePair<F, V>> features2);
}
