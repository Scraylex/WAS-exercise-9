package tools;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import cartago.*;

public class TrustManager extends Artifact {

    private HashMap<String, TrustObject> trustMap = new HashMap<>();


    @OPERATION
    public void initialize_average_rating(Object sourceAgent, Object[] trustRatings, OpFeedbackParam<Double> avg) {
      var agentName = String.valueOf(sourceAgent.toString());
      var list = Arrays.stream(trustRatings).map(Object::toString).map(Double::valueOf).collect(Collectors.toList());
      var averageTrust = calcAverage(list);
      var trustObject = new TrustObject(averageTrust, list);
      trustMap.put(agentName, trustObject);
      avg.set(averageTrust);
    }

    @OPERATION
    public void add_certified_rep(Object sourceAgent, Object crRating) {
      var agentName = String.valueOf(sourceAgent.toString());
      var rating = Double.valueOf(crRating.toString());
      TrustObject trustObject = trustMap.get(agentName);
      trustObject.setCertifiedTrust(rating);
    }

    @OPERATION
    public void get_most_trusted(OpFeedbackParam<String> agentName) {
      var max = 0d;
      String current = "";
      for(var entry : trustMap.entrySet()) {
        var itAvg = entry.getValue().getAverageTrust();
        var crRating = entry.getValue().getCertifiedTrust();
        var total = 0.5 * itAvg + 0.5 * crRating;
        if(total > max) {
          max = total;
          current = entry.getKey();
        }
      }
      agentName.set(current);
    }

    private Double calcAverage(List<Double> list) {
      double sum = 0d;
      for(var val : list) {
        sum += val;
      }
      return sum / list.size();
    }

    
    @OPERATION
    public void equals(Object sourceAgent, Object other, OpFeedbackParam<Boolean> isEqual) {
      var agentName = String.valueOf(sourceAgent.toString());
      var otherAgentName = String.valueOf(other.toString());
      isEqual.set(agentName.equals(otherAgentName));
    }

    

    private static class TrustObject {
        private double averageTrust;
        private List<Double> history;
        private double certifiedTrust;

        public TrustObject(double averageTrust, List<Double> history) {
          this.averageTrust = averageTrust;
          this.history = history;
        }

        public double getAverageTrust() {
          return averageTrust;
        }

        public List<Double> getHistory() {
          return history;
        }

        public double getCertifiedTrust() {
          return certifiedTrust;
        }

        public void setCertifiedTrust(double certifiedTrust) {
          this.certifiedTrust = certifiedTrust;
        }
    }
}
