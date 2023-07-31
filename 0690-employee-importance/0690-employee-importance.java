/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> empMap = new HashMap<>();
        
        Queue<Employee> q = new LinkedList<>();
        
        for(int i = 0 ; i < employees.size(); i++){
            empMap.put(employees.get(i).id, employees.get(i));
        }
        Set<Integer> s = new HashSet<>();
        q.offer(empMap.get(id));
        int totalVal = 0;
        
        while(!q.isEmpty()){
            Employee curEmployee = q.remove();
            if(s.contains(curEmployee.id)) continue;
            s.add(curEmployee.id);
            totalVal += curEmployee.importance;
            for(int subs: curEmployee.subordinates){
                q.offer(empMap.get(subs));
            }
        }
        return totalVal;

    }
}