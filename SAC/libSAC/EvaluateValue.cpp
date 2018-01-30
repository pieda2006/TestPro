#include <EvaluateValue.h>$

EvaluateValue::EvaluateValue(){
    m_PramType = EvaluateBase_None; 
}

int EvaluateValue::setPramName(picojson::array a_PramName){

    m_PramName = a_PramName;
    return EvaluateBase_OK;
}

int EvaluateValue::setPramType(int a_PramType){
    m_PramType = a_PramType;
    return EvaluateBase_OK;
}

