package placy.dto.requests

interface RequestParams {
   fun toList() : List<Pair<String, Any?>>
}