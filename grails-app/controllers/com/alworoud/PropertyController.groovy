package com.alworoud

import org.grails.plugin.easygrid.Easygrid

@Easygrid
class PropertyController {
    
    static grids = {
        propGrid {
            dataSourceType 'domain'
            domainClass Property
            gridImpl 'jqgrid'
            jqgrid {
                width '"750"'
            }
            columns {
                id {
                    filterClosure {params ->
                        def val=params.id,op
                        if (val.length() > 2){
                            op=params.id[1]
                            if (op == '='){
                                val=params.id[2..-1]
                                op=params.id[0]
                                if (op == '<'){
                                    le('id',"${val}".toLong())
                                }else if (op == '>'){
                                    ge('id',"${val}".toLong())
                                }
                            }
                        } else if (params.id.length() > 1) {
                            val=params.id[1..-1]
                            op=params.id[0]
                            if (op == '<'){
                                lt('id',"${val}".toLong())
                            }else if (op == '>'){
                                gt('id',"${val}".toLong())
                            }else if (op == '='){
                                eq('id',"${val}".toLong())
                            }
                        }
                    }
                    jqgrid{
                        formatter 'linkId'
                    }   
                }
                propType {
                    filterClosure {params ->
                        ilike('propType', "%${params.propType}%")
                    }
                    jqgrid {
                        editable false
                    }
                }
                street{
                    filterClosure{params ->
                        ilike('street',"%${params.street}%")
                    }    
                }
                city{
                    filterClosure{params ->
                        ilike('city',"%${params.city}%")
                    }    
                }
                status {
                    filterClosure {params ->
                        ilike('status', "%${params.status}%")
                    }
                }
                remarks {
                    filterClosure {params ->
                        ilike('remarks', "%${params.remarks}%")
                    }
                }
            }
        }
    }
    
    def grid(){}
    static scaffold = true
}
